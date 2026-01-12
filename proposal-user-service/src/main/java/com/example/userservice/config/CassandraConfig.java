package com.example.userservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(
        basePackages = "com.example.userservice.repository.cassandra",
        cassandraTemplateRef = "cassandraTemplate"
)
public class CassandraConfig { /* ... */ }
