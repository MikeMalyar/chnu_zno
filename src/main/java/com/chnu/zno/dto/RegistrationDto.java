package com.chnu.zno.dto;

import com.chnu.zno.enums.UserRole;

public class RegistrationDto {

    private String login;
    private String password;
    private UserRole userRole;

    public String getLogin() {
        return login;
    }

    public RegistrationDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public RegistrationDto setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }
}
