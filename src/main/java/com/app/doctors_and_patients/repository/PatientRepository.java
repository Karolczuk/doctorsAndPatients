package com.app.doctors_and_patients.repository;

import com.app.doctors_and_patients.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
