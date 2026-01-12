package com.example.userservice.service.strategy;

import com.example.userservice.entity.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component("password")
public class PasswordLoginStrategy implements LoginStrategy {

    @Override
    public ResponseEntity<?> login(UserDto userDto) {

        return null;
    }
}