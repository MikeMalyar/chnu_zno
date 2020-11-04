package com.chnu.zno.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {

    TEACHER,
    STUDENT,
    ADMIN;

    @Override
    public String getAuthority() {
        return toString();
    }
}
