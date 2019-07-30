package com.app.doctors_and_patients.service;

import com.app.doctors_and_patients.domain.Role;
import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.domain.City;
import com.app.doctors_and_patients.domain.Doctor;
import com.app.doctors_and_patients.domain.Specialisation;
import com.app.doctors_and_patients.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;


    public void add(DoctorDto doctorDto) {

        if (doctorDto == null) {
            throw new AppException("doctor is null");
        }
        System.out.println("DOCTORdTO" +doctorDto);
        Doctor doctor = ModelMapper.fromDoctorDtoToDoctor(doctorDto);
        System.out.println("DOCTOR - " +doctor);

        doctor.setPhotoFilename(FileService.save(doctorDto.getFile()));
        doctor.setRole(Role.ROLE_DOCTOR);
        doctor.setEnabled(true);
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));

        doctorRepository.save(doctor);
//        doctorRepository.save(ModelMapper.fromDoctorDtoToDoctor(doctorDto));
    }

    public List<Doctor> findBySpecialisaton(List<Specialisation> specialisations, List<City> cities) {
        return doctorRepository.findBySpecialisationsInAndCitiesIn(specialisations, cities);
    }


    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(new Doctor());
    }
}
