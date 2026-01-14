package com.example.typingtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.typingtest.service.UserService;

@RestController
public class DebugController {

    private final UserService userService;

    public DebugController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test-db")
    public String testDb() {
        userService.registerUser("railway_test", "password123");
        return "User inserted";
    }
}
