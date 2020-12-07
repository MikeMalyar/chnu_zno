package com.chnu.zno.controller;

import com.chnu.zno.dto.LoginDto;
import com.chnu.zno.dto.RegistrationDto;
import com.chnu.zno.rest.GenericResponse;
import com.chnu.zno.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Api(description = "Controller for actions with user")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Login endpoint for user")
    @PostMapping("/login")
    public GenericResponse login(@RequestBody LoginDto loginDto) {
        return GenericResponse.of(userService.login(loginDto));
    }

    @ApiOperation(value = "Endpoint for user registration")
    @PostMapping("/register")
    public GenericResponse register(@RequestBody RegistrationDto registrationDto) {
        return GenericResponse.of(userService.register(registrationDto));
    }

    @ApiOperation(value = "Endpoint for user logout")
    @PostMapping("/logout")
    public GenericResponse logout(SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return new GenericResponse().setSuccess(true);
    }

    @ApiOperation(value = "Endpoint checks if the login is available")
    @PostMapping("/checkLogin")
    public GenericResponse checkLogin(@RequestParam String login) {
        return GenericResponse.of(userService.checkLogin(login));
    }
}
