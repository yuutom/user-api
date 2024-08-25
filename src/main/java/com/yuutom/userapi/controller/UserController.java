package com.yuutom.userapi.controller;

import com.yuutom.userapi.entity.User;
import com.yuutom.userapi.model.CreateUserRequest;
import com.yuutom.userapi.model.SignupResponse;
import com.yuutom.userapi.usecase.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements SignupApi{
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
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

}
