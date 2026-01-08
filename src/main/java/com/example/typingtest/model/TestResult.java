package com.example.typingtest.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "test_results")
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int wpm;
    private int accuracy;

    private LocalDateTime takenAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public TestResult() {}

    public TestResult(int wpm, int accuracy, User user) {
        this.wpm = wpm;
        this.accuracy = accuracy;
        this.user = user;
        this.takenAt = LocalDateTime.now();
    }

    public int getWpm() {
        return wpm;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public LocalDateTime getTakenAt() {
        return takenAt;
    }

    public User getUser() {
        return user;
    }
}
