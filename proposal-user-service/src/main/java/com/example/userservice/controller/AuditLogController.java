package com.example.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/audit")
public class AuditLogController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/log")
    public ResponseEntity<String> logAction(@RequestParam String user,
                                            @RequestParam String action,
                                            @RequestParam String proposalId) {
        String logMessage = String.format("User [%s] performed [%s] on Proposal [%s] at [%s]",
                user, action, proposalId, LocalDateTime.now());

        kafkaTemplate.send("proposal-audit-log", logMessage);
        return ResponseEntity.ok("Audit log sent.");
    }
}