package com.example.typingtest.service;

import org.springframework.stereotype.Service;

import com.example.typingtest.model.TestResult;
import com.example.typingtest.model.User;
import com.example.typingtest.repository.TestResultRepository;

@Service
public class TestResultService {

    private final TestResultRepository repository;

    public TestResultService(TestResultRepository repository) {
        this.repository = repository;
    }

    public void saveResult(int wpm, int accuracy, User user) {
        TestResult result = new TestResult(wpm, accuracy, user);
        repository.save(result);
    }
}
