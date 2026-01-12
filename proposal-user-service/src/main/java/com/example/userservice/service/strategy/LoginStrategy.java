package com.example.userservice.service.strategy;

import com.example.userservice.entity.UserDto;
import org.springframework.http.ResponseEntity;

public interface LoginStrategy {
    ResponseEntity<?> login(UserDto userDto);
}