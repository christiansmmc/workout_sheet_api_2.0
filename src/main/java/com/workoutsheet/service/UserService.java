package com.workoutsheet.service;

import com.workoutsheet.domain.User;
import com.workoutsheet.domain.enumeration.UserRole;
import com.workoutsheet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public User create(User user) {
        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }

    public boolean isEmailRegistered(String email) {
        return repository.existsByEmail(email);
    }
}
