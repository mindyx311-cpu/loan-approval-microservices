package com.example.userservice.service.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginStrategyFactory {
    private final Map<String, LoginStrategy> strategies;

    @Autowired
    public LoginStrategyFactory(Map<String, LoginStrategy> strategies) {
        this.strategies = strategies;
    }

    public LoginStrategy getStrategy(String type) {
        return strategies.get(type);
    }
}
