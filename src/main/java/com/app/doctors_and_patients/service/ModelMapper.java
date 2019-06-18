package com.app.doctors_and_patients.service;

import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.dto.PatientDto;
import com.app.doctors_and_patients.dto.VisitDto;
import com.app.doctors_and_patients.model.Doctor;
import com.app.doctors_and_patients.model.Patient;
import com.app.doctors_and_patients.model.Visit;


public interface ModelMapper {

    static PatientDto fromPatientToPatientDto(Patient patient) {
        return patient == null ? null : PatientDto.builder()
                .id(patient.getId())
                .name(patient.getName())
                .surname(patient.getSurname())
                .age(patient.getAge())
                .email(patient.getEmail())
                .gender(patient.getGender())
                .build();
    }

    static Patient fromPatientDtoToPatient(PatientDto patientDto) {
        return patientDto == null ? null : Patient.builder()
                .id(patientDto.getId())
                .name(patientDto.getName())
                .surname(patientDto.getSurname())
                .age(patientDto.getAge())
                .email(patientDto.getEmail())
                .gender(patientDto.getGender())
                .build();
    }

    static DoctorDto fromDoctorToDoctorDto(Doctor doctor) {
        return doctor == null ? null : DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .age(doctor.getAge())
                .email(doctor.getEmail())
                .employmentDate(doctor.getEmploymentDate())
                .experience(doctor.getExperience())
                .gender(doctor.getGender())
                .specialisations(doctor.getSpecialisations())
                .photoFilename(doctor.getPhotoFilename())
                .build();
    }

    static Doctor fromDoctorDtoToDoctor(DoctorDto doctorDto) {
        return doctorDto == null ? null : Doctor.builder()
                .id(doctorDto.getId())
                .name(doctorDto.getName())
                .age(doctorDto.getAge())
                .email(doctorDto.getEmail())
                .employmentDate(doctorDto.getEmploymentDate())
                .experience(doctorDto.getExperience())
                .gender(doctorDto.getGender())
                .specialisations(doctorDto.getSpecialisations())
                .photoFilename(doctorDto.getPhotoFilename())
                .build();
    }

    static Visit fromVisitDtoToVisit(VisitDto visitDto) {
        return visitDto == null ? null : Visit.builder()
                .id(visitDto.getId())
                .doctor(visitDto.getDoctorDto() == null ? null : fromDoctorDtoToDoctor(visitDto.getDoctorDto()))
                .patient(visitDto.getPatientDto() == null ? null : fromPatientDtoToPatient(visitDto.getPatientDto()))
                .cost(visitDto.getCost())
                .dateTime(visitDto.getDateTime())
                .build();
    }

//    static VisitDto fromVisitDtoToVisit(Visit visit) {
//        return visit == null ? null : Visit.builder()
//                .id(visit.getId())
//                .doctor(visit.getDoctor() == null ? null : fromDoctorDtoToDoctor(visit.getDoctor()))
//                .patient(visit.getPatient() == null ? null : fromPatientToPatientDto(visit.getPatient()))
//                .cost(visit.getCost())
//                .dateTime(visit.getDateTime())
//                .build();
//    }
}

