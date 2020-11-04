package com.chnu.zno.controller;

import com.chnu.zno.dto.LoginDto;
import com.chnu.zno.dto.RegistrationDto;
import com.chnu.zno.rest.GenericResponse;
import com.chnu.zno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public GenericResponse login(@RequestBody LoginDto loginDto) {
        return GenericResponse.of(userService.login(loginDto));
    }

    @PostMapping("/register")
    public GenericResponse register(@RequestBody RegistrationDto registrationDto) {
        return GenericResponse.of(userService.register(registrationDto));
    }
}
