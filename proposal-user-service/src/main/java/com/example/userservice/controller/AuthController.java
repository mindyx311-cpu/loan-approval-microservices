package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.entity.UserDto;

import com.example.userservice.repository.jpa.UserRepository;
import com.example.userservice.security.JwtUtil;
import com.example.userservice.service.strategy.LoginStrategy;
import com.example.userservice.service.strategy.LoginStrategyFactory;
import com.example.userservice.service.strategy.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userService;

    @Autowired
    private LoginStrategyFactory strategyFactory;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");

        userService.registerUser(user);
        return "Register successful";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto){
        LoginStrategy strategy = strategyFactory.getStrategy(userDto.getLoginType());
        return strategy.login(userDto);
    }
}