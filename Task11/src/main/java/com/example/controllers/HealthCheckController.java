package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController
{
    @GetMapping("/health")
    public String checkHealth() {
        return "Application is up and running!";
    }
}