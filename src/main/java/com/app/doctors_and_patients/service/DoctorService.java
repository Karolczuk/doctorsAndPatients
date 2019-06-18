package com.app.doctors_and_patients.service;

import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public void add(DoctorDto doctorDto) {

        if (doctorDto == null) {
            throw new AppException("doctor is null");
        }

        doctorRepository.save(ModelMapper.fromDoctorDtoToDoctor(doctorDto));
    }


}
