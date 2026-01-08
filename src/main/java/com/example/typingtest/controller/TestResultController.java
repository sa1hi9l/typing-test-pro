package com.example.typingtest.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.typingtest.model.User;
import com.example.typingtest.repository.UserRepository;
import com.example.typingtest.service.TestResultService;

@Controller
public class TestResultController {

    private final TestResultService resultService;
    private final UserRepository userRepository;

    public TestResultController(TestResultService resultService,
                                UserRepository userRepository) {
        this.resultService = resultService;
        this.userRepository = userRepository;
    }

    @PostMapping("/submitResult")
    public String saveResult(@RequestParam int wpm,
                             @RequestParam int accuracy,
                             Principal principal) {

        String username = principal.getName();
        User user = userRepository.findByUsername(username).orElseThrow();

        resultService.saveResult(wpm, accuracy, user);
        return "redirect:/dashboard";
    }
}
