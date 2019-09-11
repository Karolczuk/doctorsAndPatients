package com.app.doctors_and_patients.service;

import com.app.doctors_and_patients.domain.Doctor;
import com.app.doctors_and_patients.domain.Patient;
import com.app.doctors_and_patients.domain.Role;
import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.dto.PatientDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.repository.PatientRepository;
import com.app.doctors_and_patients.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void add(PatientDto patientDto) {

        if (patientDto == null) {
            throw new AppException("patient is null");
        }

        Patient patient = ModelMapper.fromPatientDtoToPatient(patientDto);

        patient.setRole(Role.ROLE_PATIENT);
        patient.setEnabled(true);
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        userRepository.save(patient);

        //patientRepository.save(patient);

    }


    public PatientDto findOne(Long id) {

        if (id == null) {
            throw new AppException("Worker service - find one - id is null");
        }

        return patientRepository
                .findById(id)
                .map(ModelMapper::fromPatientToPatientDto)
                .orElseThrow(() -> new AppException("No patient with id " + id));
    }

    public PatientDto update(PatientDto patientDto) {

        if (patientDto.getId() == null) {
            throw new AppException("Patient service - update - id is null");
        }

        return patientRepository
                .findById(patientDto.getId())
                .map(patientFromDb -> {

                    patientFromDb.setUsername(patientDto.getUsername() == null ? patientFromDb.getUsername() : patientDto.getUsername());
                    patientFromDb.setEmail(patientDto.getEmail() == null ? patientFromDb.getEmail() : patientDto.getEmail());

                    return ModelMapper.fromPatientToPatientDto(patientRepository.save(patientFromDb));
                }).orElseThrow(() -> new AppException("Patient service - update - cannot update patient with id " + patientDto.getId()));

    }

    public PatientDto delete(Long id) {

        if (id == null) {
            throw new AppException("Patient service - delete - id is null");
        }
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new AppException("Patient service - delete - no patient with id " + id));
        patientRepository.deleteById(id);
        return ModelMapper.fromPatientToPatientDto(patient);
    }
}
