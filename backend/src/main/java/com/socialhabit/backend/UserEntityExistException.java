package com.socialhabit.backend;

public class UserEntityExistException extends RuntimeException {
    UserEntityExistException(String login) {
        super("User with login " + login + " exists");
    }
}

