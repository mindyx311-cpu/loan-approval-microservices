package com.example.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ProposalReminderTask {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Scheduled(fixedRate = 30000)
    public void checkAndSendReminders() {

        List<String> expiringProposals = List.of("P1001", "P1002");

        for (String proposalId : expiringProposals) {
            String msg = String.format("Reminder: Proposal [%s] is about to expire on [%s]",
                    proposalId, LocalDate.now().plusDays(1));

            kafkaTemplate.send("proposal-deadline-reminder", msg);
            System.out.println("Reminder sent：" + msg);
        }
    }
}