package com.example.demoLoginSignUp.Jwt;

import com.example.demoLoginSignUp.models.UserInformation;
import com.example.demoLoginSignUp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInformation userInformation = userRepository.findByEmail(email);
        if (userInformation == null) {

            throw new UsernameNotFoundException("User Not Found ", null);

        }


        return new User(userInformation.getEmail(), userInformation.getPassword(), new ArrayList<>());
//        return new org.springframework.security.core.userdetails.User(UserInformation.getEmail(),user.getPassword(),new ArrayList<>());

    }
}
