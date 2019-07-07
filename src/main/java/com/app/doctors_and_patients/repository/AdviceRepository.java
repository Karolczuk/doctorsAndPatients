package com.app.doctors_and_patients.repository;

import com.app.doctors_and_patients.domain.Advice;
import com.app.doctors_and_patients.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdviceRepository extends JpaRepository<Advice, Long> {

    public Doctor findByDoctor_Name(String name);
}
