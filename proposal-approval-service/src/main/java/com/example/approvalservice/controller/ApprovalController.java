package com.example.approvalservice.controller;

import com.example.approvalservice.dto.ApprovalEvent;
import com.example.approvalservice.service.ApprovalEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/approval")
@RequiredArgsConstructor
public class ApprovalController {

    @GetMapping("/test")
    public String test() {
        return "approval test response";
    }

    private final ApprovalEventPublisher approvalEventPublisher;

    @PostMapping("/test-event")
    public String testPublish() {
        ApprovalEvent event = new ApprovalEvent();
        event.setUserId(123L);
        event.setFormId(456L);
        event.setStatus("APPROVED");
        event.setReason("demo");

        approvalEventPublisher.publish(event);
        return "Event sent to SQS!";
    }
}