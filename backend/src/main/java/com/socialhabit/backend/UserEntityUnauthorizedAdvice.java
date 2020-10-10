package com.socialhabit.backend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserEntityUnauthorizedAdvice {
    @ResponseBody
    @ExceptionHandler(UserEntityUnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String userEntityUnauthorized(UserEntityUnauthorizedException exception) {
        return exception.getMessage();
    }
}
