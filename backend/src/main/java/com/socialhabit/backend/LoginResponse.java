package com.socialhabit.backend;

public class LoginResponse {
    private int error;
    private String token = null;

    LoginResponse(int error, String token) {
        this.error = error;
        this.token = token;
    }
}
