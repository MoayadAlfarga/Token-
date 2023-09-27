package com.example.demoLoginSignUp.repository;


import com.example.demoLoginSignUp.models.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInformation, Long> {

    boolean existsByEmail(String email);

    UserInformation findByEmail(String email);


}
