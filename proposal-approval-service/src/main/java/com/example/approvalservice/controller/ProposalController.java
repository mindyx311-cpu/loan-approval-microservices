package com.example.approvalservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/proposals")
public class ProposalController {


    private final Map<Long, String> proposals = new HashMap<>();
    private long currentId = 1;

    // Submit
    @PostMapping
    public ResponseEntity<?> createProposal(@RequestBody String content) {
        long id = currentId++;
        proposals.put(id, content);
        return ResponseEntity.status(201).body("Proposal submitted with ID: " + id);
    }

    // Get
    @GetMapping
    public ResponseEntity<?> getAllProposals() {
        return ResponseEntity.ok(proposals);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProposal(@PathVariable Long id, @RequestBody String updatedContent) {
        if (!proposals.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        proposals.put(id, updatedContent);
        return ResponseEntity.ok("Proposal updated.");
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProposal(@PathVariable Long id) {
        if (!proposals.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        proposals.remove(id);
        return ResponseEntity.ok("Proposal deleted.");
    }
}