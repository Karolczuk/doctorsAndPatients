package com.app.doctors_and_patients.service;
import com.app.doctors_and_patients.domain.Patient;
import com.app.doctors_and_patients.domain.Role;
import com.app.doctors_and_patients.dto.PatientDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;

    public void add(PatientDto patientDto) {

        if (patientDto == null) {
            throw new AppException("patient is null");
        }

        Patient patient = ModelMapper.fromPatientDtoToPatient(patientDto);

        patient.setRole(Role.ROLE_PATIENT);
        patient.setEnabled(true);
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));

        patientRepository.save(patient);

    }
}
