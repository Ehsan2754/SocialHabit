package com.socialhabit.backend;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginUserEntityController {
    private final UserEntityRepository repository;

    LoginUserEntityController(UserEntityRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/login")
    LoginResponse one(@RequestParam("login") String login, @RequestParam("password") String password) {
        UserEntity logOutUser = repository.findById(login)
                .orElseThrow(() -> new UserEntityUnauthorizedException(new LoginResponse(0, null).toString()));
        if (logOutUser.getPassword().compareTo(password) != 0) {
            throw new UserEntityUnauthorizedException(new LoginResponse(0, null).toString());
        }
        LoginResponse goodResponse = new LoginResponse(0, logOutUser.getToken());
        return goodResponse;
    }

    @GetMapping(value = "/isUserExist")
    EntityModel<UserEntity> getOne(@RequestParam("login") String login) {
        UserEntity user = repository.findById(login).orElseThrow(() -> new RuntimeException("No such user"));
        return EntityModel.of(user);
    }
}

