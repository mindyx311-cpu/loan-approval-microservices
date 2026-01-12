package com.example.userservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic newProposalTopic() {
        return TopicBuilder.name("new-proposal-topic")
                .partitions(3)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic auditLogTopic() {
        return TopicBuilder.name("proposal-audit-log")
                .partitions(2)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic deadlineReminderTopic() {
        return TopicBuilder.name("proposal-deadline-reminder")
                .partitions(2)
                .replicas(1)
                .build();
    }
}