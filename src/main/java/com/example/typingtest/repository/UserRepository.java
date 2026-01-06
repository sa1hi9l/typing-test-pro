package com.example.typingtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.typingtest.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
