package com.example.demoLoginSignUp.service;

import com.example.demoLoginSignUp.dto.RequestSignUpDto;
import com.example.demoLoginSignUp.dto.UserDto;
import com.example.demoLoginSignUp.models.UserInformation;
import com.example.demoLoginSignUp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationImpl implements AuthenticationService {

    private UserRepository userRepository;

    @Autowired
    public AuthenticationImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto create(RequestSignUpDto requestSignUpDto) {

        if (userRepository.existsByEmail(requestSignUpDto.getEmail())) {

            throw new RuntimeException("User with this email already exists");
        }
        UserInformation user = new UserInformation();
        user.setFirstName(requestSignUpDto.getFirstName());
        user.setLastName(requestSignUpDto.getLastName());
        user.setPhoneNumber(requestSignUpDto.getPhoneNumber());
        user.setEmail(requestSignUpDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(requestSignUpDto.getPassword()));
        UserInformation createUser = userRepository.save(user);

        UserDto userDTO = new UserDto();
        userDTO.setId(createUser.getId());
        userDTO.setFirstName(createUser.getFirstName());
        userDTO.setLastName(createUser.getLastName());
        userDTO.setEmail(createUser.getEmail());
        userDTO.setPhoneNumber(createUser.getPhoneNumber());
        return userDTO;
    }


    @Override
    public UserDto createUser(RequestSignUpDto requestSignUpDto) {

        if (userRepository.existsByEmail(requestSignUpDto.getEmail())) {

            throw new RuntimeException("User with this email already exists");
        }
        UserInformation user = new UserInformation();
        user.setFirstName(requestSignUpDto.getFirstName());
        user.setLastName(requestSignUpDto.getLastName());
        user.setPhoneNumber(requestSignUpDto.getPhoneNumber());
        user.setEmail(requestSignUpDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(requestSignUpDto.getPassword()));
        UserInformation createUser = userRepository.save(user);

        UserDto userDTO = new UserDto();
        userDTO.setId(createUser.getId());
        userDTO.setFirstName(createUser.getFirstName());
        userDTO.setLastName(createUser.getLastName());
        userDTO.setEmail(createUser.getEmail());
        userDTO.setPhoneNumber(createUser.getPhoneNumber());
        return userDTO;

    }
}
