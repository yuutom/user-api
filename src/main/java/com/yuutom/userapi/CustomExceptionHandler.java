package com.yuutom.userapi;

import com.yuutom.userapi.controller.UserController;
import com.yuutom.userapi.model.ErrorResponse;
import com.yuutom.userapi.usecase.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserService.DuplicateUserException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateUserException(UserService.DuplicateUserException ex) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ErrorResponse(){{
                setMessage("Account creation failed");
                setCause("already same user_id is used");
            }});
    }

    @ExceptionHandler(UserController.UnAuthorizationHeaderException.class)
    public ResponseEntity<ErrorResponse> handleUnAuthorizationHeaderException(UserController.UnAuthorizationHeaderException ex) {
        return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(new ErrorResponse(){{
                setMessage("Authentication Failed");
            }});
    }

    @ExceptionHandler(UserService.UserNotExistException.class)
    public ResponseEntity<ErrorResponse> handleUserNotExistException(UserService.UserNotExistException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(new ErrorResponse(){{
                setMessage("No User found");
            }});
    }

    @ExceptionHandler(UserService.DuplicateSubscriptionException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateSubscriptionException(UserService.DuplicateSubscriptionException ex) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(new ErrorResponse(){{
                setMessage("Account creation failed");
                setCause("already same user_id is used");
            }});
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ErrorResponse(){{
                setMessage("Account creation failed");
                setCause("required user_id and password");
            }});
    }

    @ExceptionHandler(UserService.UnauthorizedTopicException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedTopicException(UserService.UnauthorizedTopicException ex) {
        return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(new ErrorResponse(){{
                setMessage("Account creation failed");
                setCause("already same user_id is used");
            }});
    }

    @ExceptionHandler(UserService.NotSubscribeTopicException.class)
    public ResponseEntity<ErrorResponse> handleNotSubscribeTopicException(UserService.NotSubscribeTopicException ex) {
        return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(new ErrorResponse(){{
                setMessage("Account creation failed");
                setCause("already same user_id is used");
            }});
    }
}
