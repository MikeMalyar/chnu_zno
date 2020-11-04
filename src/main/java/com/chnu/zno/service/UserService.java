package com.chnu.zno.service;

import com.chnu.zno.dto.LoginDto;
import com.chnu.zno.dto.RegistrationDto;
import com.chnu.zno.model.User;

public interface UserService {

    boolean login(LoginDto loginDto);

    User register(RegistrationDto registrationDto);
}
