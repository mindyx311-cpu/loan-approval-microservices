package com.example.userservice.controller;

import com.example.userservice.entity.CassandraUser;

import com.example.userservice.repository.cassandra.CassandraUserRepository;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cassandra/users")
public class CassandraUserController {

    private final CassandraUserRepository userRepository;

    public CassandraUserController(CassandraUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<CassandraUser> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public CassandraUser createUser(@RequestBody CassandraUser user) {
        user.setUserId(UUID.randomUUID());
        user.setCreatedAt(Instant.now());
        return userRepository.save(user);
    }
}