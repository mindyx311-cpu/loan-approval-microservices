package com.example.approvalservice.service;

import com.example.approvalservice.dto.ApprovalEvent;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApprovalEventPublisher {

    private final SqsTemplate sqsTemplate;

    @Value("${app.sqs.approval-queue-name}")
    private String approvalQueueName;

    public void publish(ApprovalEvent event) {
        event.setEventId(UUID.randomUUID().toString());
        event.setTimestamp(Instant.now());
        sqsTemplate.send(approvalQueueName, event);
        System.out.println("ApprovalEvent published to SQS: " + event);
    }
}