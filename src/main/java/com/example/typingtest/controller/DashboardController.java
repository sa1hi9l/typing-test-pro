package com.example.typingtest.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.typingtest.model.TestResult;
import com.example.typingtest.model.User;
import com.example.typingtest.repository.UserRepository;
import com.example.typingtest.service.TestResultService;

@Controller
public class DashboardController {

    private final TestResultService resultService;
    private final UserRepository userRepository;

    public DashboardController(TestResultService resultService,
                               UserRepository userRepository) {
        this.resultService = resultService;
        this.userRepository = userRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {

        String username = principal.getName();
        User user = userRepository.findByUsername(username).orElseThrow();

        List<TestResult> results = resultService.getResultsForUser(user);

        model.addAttribute("results", results);
        model.addAttribute("username", username);

        return "dashboard";
    }
}
