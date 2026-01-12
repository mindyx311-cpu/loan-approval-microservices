package com.example.userservice.controller;
import com.example.userservice.entity.User;

import com.example.userservice.repository.jpa.UserRepository;
import com.example.userservice.service.KafkaMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //database
    @GetMapping
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    //kafka
    @Autowired
    private KafkaMessageSender kafkaSender;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody com.example.userservice.entity.UserDto dto) {

        kafkaSender.sendMessage("user-events", "User registered: " + dto.getUsername());
        return ResponseEntity.ok("Registered");
    }
}
