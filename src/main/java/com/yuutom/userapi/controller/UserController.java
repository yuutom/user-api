package com.yuutom.userapi.controller;

import com.yuutom.userapi.entity.User;
import com.yuutom.userapi.model.*;
import com.yuutom.userapi.usecase.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Optional;

@RestController
public class UserController implements SignupApi, UsersApi, CloseApi{
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return SignupApi.super.getRequest();
    }

    @Override
    public ResponseEntity<SignupResponse> createUser(CreateUserRequest request) {
        User user = userService.create(request.getUserId(), request.getPassword());
        var response = new SignupResponse();
        response.setMessage("Account successfully created");
        response.setUser(new com.yuutom.userapi.model.User(){{
            setUserId(user.getUserId());
            setNickname(user.getNickname());
        }});
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<GetUserResponse> getUser(String userIdParam, @RequestHeader("Authorization") String authorizationHeader){
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            // Basic 認証ヘッダーから認証情報を抽出
            String base64Credentials = authorizationHeader.substring("Basic ".length());
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            // 認証情報は "username:password" の形式
            String[] values = credentials.split(":", 2);
            String userId = values[0];
            String password = values[1];
            var response = new GetUserResponse();
            response.setMessage("User details by user_id");
            User user = userService.getUser(userId, password);
            response.setUser(new com.yuutom.userapi.model.User(){{
                setUserId(user.getUserId());
                setNickname(user.getNickname());
            }});
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        throw new UnAuthorizationHeaderException("unauthorized header");
    }

    @Override
    public ResponseEntity<UpdateUser200Response> updateUser(String userIdParam, UpdateUserRequest request, @RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            // Basic 認証ヘッダーから認証情報を抽出
            String base64Credentials = authorizationHeader.substring("Basic ".length());
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            // 認証情報は "username:password" の形式
            String[] values = credentials.split(":", 2);
            String userId = values[0];
            String password = values[1];
            var response = new UpdateUser200Response();
            response.setMessage("User successfully updated");
            User user = userService.updateUser(userId, password, request.getNickname(), request.getComment());
            response.setRecipe(new ArrayList<>(){{
                add(new com.yuutom.userapi.model.User(){{
                    setNickname(user.getNickname());
                    setComment(user.getComment());
                }});
            }});
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        throw new UnAuthorizationHeaderException("unauthorized header");
    }

    @Override
    public ResponseEntity<DeleteUserResponse> deleteUser(@RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            // Basic 認証ヘッダーから認証情報を抽出
            String base64Credentials = authorizationHeader.substring("Basic ".length());
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            // 認証情報は "username:password" の形式
            String[] values = credentials.split(":", 2);
            String userId = values[0];
            String password = values[1];
            var response = new DeleteUserResponse();
            response.setMessage("Account and user successfully removed");
            userService.deleteUser(userId, password);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        throw new UnAuthorizationHeaderException("unauthorized header");
    }

    public static class UnAuthorizationHeaderException extends RuntimeException {
        public UnAuthorizationHeaderException(String message) {
            super(message);
        }
    }

}
