package com.app.doctors_and_patients.service;

import com.app.doctors_and_patients.domain.Role;
import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.domain.City;
import com.app.doctors_and_patients.domain.Doctor;
import com.app.doctors_and_patients.domain.Specialisation;
import com.app.doctors_and_patients.repository.DoctorRepository;
import com.app.doctors_and_patients.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public void add(DoctorDto doctorDto) {

        if (doctorDto == null) {
            throw new AppException("doctor is null");
        }
        Doctor doctor = ModelMapper.fromDoctorDtoToDoctor(doctorDto);
        System.out.println("-------------------- 2 -------------------------");
        System.out.println(doctor);
        System.out.println("-------------------- 2 -------------------------");

        doctor.setPhotoFilename(FileService.save(doctorDto.getFile()));
        doctor.setRole(Role.ROLE_DOCTOR);
        doctor.setEnabled(true);
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));

        //doctorRepository.save(doctor);
        userRepository.save(doctor);
    }

    public List<Doctor> findBySpecialisaton(List<Specialisation> specialisations, List<City> cities) {
        return doctorRepository.findBySpecialisationsInAndCitiesIn(specialisations, cities);
    }

    public DoctorDto findOne(Long id) {

        if (id == null) {
            throw new AppException("Doctor service - find one - id is null");
        }

        return doctorRepository
                .findById(id)
                .map(ModelMapper::fromDoctorToDoctorDto)
                .orElseThrow(() -> new AppException("No doctor with id " + id));
    }

    public DoctorDto update(DoctorDto doctorDto) {

        if (doctorDto.getId() == null) {
            throw new AppException("Doctor service - update - id is null");
        }

        return doctorRepository
                .findById(doctorDto.getId())
                .map(doctorFromDb -> {

                    doctorFromDb.setUsername(doctorDto.getUsername() == null ? doctorFromDb.getUsername() : doctorDto.getUsername());
                    doctorFromDb.setEmail(doctorDto.getEmail() == null ? doctorFromDb.getEmail() : doctorDto.getEmail());
                    doctorFromDb.setPhotoFilename(doctorDto.getPhotoFilename() == null ? doctorFromDb.getPhotoFilename() : doctorDto.getPhotoFilename());

                    return ModelMapper.fromDoctorToDoctorDto(doctorRepository.save(doctorFromDb));
                }).orElseThrow(() -> new AppException("Doctor service - update - cannot update doctor with id " + doctorDto.getId()));
    }


    public DoctorDto delete(Long id) {

        if (id == null) {
            throw new AppException("Doctor service - delete - id is null");
        }
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new AppException("Doctor service - delete - no doctor with id " + id));
        doctorRepository.deleteById(id);
        return ModelMapper.fromDoctorToDoctorDto(doctor);
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(new Doctor());
    }

}
