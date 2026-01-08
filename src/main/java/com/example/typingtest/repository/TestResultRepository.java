package com.example.typingtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.typingtest.model.TestResult;
import com.example.typingtest.model.User;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    List<TestResult> findByUser(User user);
}
