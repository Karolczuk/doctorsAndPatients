package com.app.doctors_and_patients.service;
import com.app.doctors_and_patients.dto.PatientDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public void add(PatientDto patientDto) {

        if (patientDto == null) {
            throw new AppException("patient is null");
        }

        patientRepository.save(ModelMapper.fromPatientDtoToPatient(patientDto));
    }
}
