 package com.example.typingtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PracticeController {

    @GetMapping("/practice")
    public String practiceMenu() {
        return "practice";
    }

    @GetMapping("/practice/beginner")
    public String beginner() {
        return "practice-beginner";
    }

    @GetMapping("/practice/intermediate")
    public String intermediate() {
        return "practice-intermediate";
    }

    @GetMapping("/practice/advanced")
    public String advanced() {
        return "practice-advanced";
    }
}
