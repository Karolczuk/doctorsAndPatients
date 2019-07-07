package com.app.doctors_and_patients.repository;

import com.app.doctors_and_patients.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
