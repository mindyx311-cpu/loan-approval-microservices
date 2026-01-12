package com.example.userservice.service.strategy;

import com.example.userservice.entity.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component("email")
public class EmailLoginStrategy implements LoginStrategy {

    @Override
    public ResponseEntity<?> login(UserDto userDto) {

        String email = userDto.getEmail();
        String code = userDto.getVerificationCode();


        if ("123456".equals(code)) {
            return ResponseEntity.ok("Email login success.");
        } else {
            return ResponseEntity.status(401).body("Invalid email verification code.");
        }
    }
}