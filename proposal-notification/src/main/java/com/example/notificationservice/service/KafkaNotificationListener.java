package com.example.notificationservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationListener {

    @KafkaListener(topics = "user-events", groupId = "notification-group")
    public void listen(String message) {
        System.out.println("Received Kafka message: " + message);

    }
    @KafkaListener(topics = "proposal-audit-log", groupId = "audit-group")
    public void listenAuditLog(String message) {
        System.out.println(" AUDIT LOG RECEIVED >>> " + message);

    }
    @KafkaListener(topics = "proposal-deadline-reminder", groupId = "reminder-group")
    public void handleDeadlineReminder(String message) {
        System.out.println(" Receive Proposal expiration reminder >>> " + message);

    }
}