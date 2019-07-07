package com.app.doctors_and_patients.repository;

import com.app.doctors_and_patients.domain.City;
import com.app.doctors_and_patients.domain.Doctor;
import com.app.doctors_and_patients.domain.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public List<Doctor> findBySpecialisationsInAndCitiesIn(List<Specialisation> specialisations, List<City>cities);

}
