package com.example.demoLoginSignUp.service;

import com.example.demoLoginSignUp.dto.RequestSignUpDto;
import com.example.demoLoginSignUp.dto.UserDto;

public interface AuthenticationService {
    UserDto createUser(RequestSignUpDto requestSignUpDto);

}
