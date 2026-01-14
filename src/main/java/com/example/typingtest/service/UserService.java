package com.example.typingtest.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.typingtest.model.User;
import com.example.typingtest.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository,
	                   BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
    
	@Transactional
    public User registerUser(String username, String rawPassword) {

		System.out.println(">>> Registering user: " + username);
		
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                    new UsernameNotFoundException("User not found"));

		User saved = userRepository.save(user);
		System.out.println(">>> Saved user with ID: " + saved.getId());

        return saved;
    }
}
