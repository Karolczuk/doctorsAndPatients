package com.app.doctors_and_patients.repository;

import com.app.doctors_and_patients.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
