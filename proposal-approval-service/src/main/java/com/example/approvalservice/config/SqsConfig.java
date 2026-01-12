package com.example.approvalservice.config;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Configuration
public class SqsConfig {

    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        return SqsAsyncClient.builder()
                .region(Region.US_WEST_2) // 换成你的区域
                .credentialsProvider(DefaultCredentialsProvider.create())
                // 如果本地用 LocalStack 再加 .endpointOverride(URI.create("http://localhost:4566"))
                .build();
    }

    @Bean
    public SqsTemplate sqsTemplate(SqsAsyncClient client) {
        return SqsTemplate.newTemplate(client);
    }
}