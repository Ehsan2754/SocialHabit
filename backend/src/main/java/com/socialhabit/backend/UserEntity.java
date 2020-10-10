package com.socialhabit.backend;

import org.springframework.data.annotation.Id;

import java.util.Objects;


public class UserEntity {
    private @Id String login;
    private String password;
    private String token;
    UserInfo userInfo;
    class UserInfo {
        String firstName;
        String lastName;
        String email;
        int age;
    }

    UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
        token = Objects.toString(31 * Objects.hashCode(this.login + this.password));
    }

    UserEntity (String login, String password, UserInfo userInfo) {
        this.login = login;
        this.password = password;
        this.userInfo = userInfo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}