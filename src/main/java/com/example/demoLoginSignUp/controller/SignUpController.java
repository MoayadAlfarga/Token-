package com.example.demoLoginSignUp.controller;


import com.example.demoLoginSignUp.dto.RequestSignUpDto;
import com.example.demoLoginSignUp.dto.UserDto;
import com.example.demoLoginSignUp.repository.UserRepository;
import com.example.demoLoginSignUp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SignUpController {
    private AuthenticationService authenticationService;
    private UserRepository userRepository;

    @Autowired
    public SignUpController(AuthenticationService authenticationService, UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody RequestSignUpDto requestSignUpDto) {

        if (userRepository.existsByEmail(requestSignUpDto.getEmail())) {


            return new ResponseEntity<>("User With Email is Already exists", HttpStatus.BAD_REQUEST);
        }
        UserDto createUser = authenticationService.createUser(requestSignUpDto);

        if (createUser == null) {

            return new ResponseEntity<>("User is not Created , try again Later .", HttpStatus.BAD_REQUEST);


        }
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);


    }


}
