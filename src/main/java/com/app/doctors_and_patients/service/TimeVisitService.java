package com.app.doctors_and_patients.service;

import com.app.doctors_and_patients.domain.Patient;
import com.app.doctors_and_patients.domain.Role;
import com.app.doctors_and_patients.dto.PatientDto;
import com.app.doctors_and_patients.dto.TimeVisitDto;
import com.app.doctors_and_patients.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeVisitService {

    private final DoctorRepository doctorRepository;


    public void add(TimeVisitDto timeVisitDto) {

        doctorRepository.findById(timeVisitDto.getDoctorId()).ifPresent(
                doctor -> {
                    doctor.setTimeVisit(timeVisitDto);
                    doctorRepository.save(doctor);
                }
        );


    }


}
