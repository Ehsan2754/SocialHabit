package com.socialhabit.backend;

class UserEntityUnauthorizedException extends RuntimeException {
    UserEntityUnauthorizedException(String response) {
        super(response);
    }
}