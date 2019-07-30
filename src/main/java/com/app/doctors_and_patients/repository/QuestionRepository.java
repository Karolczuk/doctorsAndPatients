package com.app.doctors_and_patients.repository;


import com.app.doctors_and_patients.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
