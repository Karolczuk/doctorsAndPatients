package com.app.doctors_and_patients.service;


import com.app.doctors_and_patients.domain.User;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(User user) {

        if ( user == null ) {
            throw new AppException("user object is null");
        }

        if ( userRepository.findByUsername(user.getUsername()).isPresent() ) {
            throw new AppException("user with username " + user.getUsername() + " already exists");
        }

        if (!Objects.equals(user.getPassword(), user.getPasswordConfirmation())) {
            throw new AppException("password are not correct");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);

        return null;
    }
}
