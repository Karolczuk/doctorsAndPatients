package com.app.doctors_and_patients.repository;

import com.app.doctors_and_patients.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
