package com.app.doctors_and_patients.repository;

import com.app.doctors_and_patients.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;


public interface UserRepository <T extends User> extends JpaRepository<T, Long> {

    Optional<T> findByEmail(String email);
    Optional<T> findByUsername(String username);

}
