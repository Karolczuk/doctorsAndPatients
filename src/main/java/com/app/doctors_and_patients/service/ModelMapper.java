package com.app.doctors_and_patients.service;

import com.app.doctors_and_patients.domain.*;
import com.app.doctors_and_patients.dto.*;

import java.util.HashSet;


public interface ModelMapper {

    static UserDto fromPatientToPatientDto(User patient) {
        return patient == null ? null : UserDto.builder()
                .id(patient.getId())
                .name(patient.getName())
                .surname(patient.getSurname())
                .age(patient.getAge())
                .email(patient.getEmail())
                .gender(patient.getGender())
                .enabled(patient.getEnabled())
                .build();
    }

    static User fromPatientDtoToPatient(UserDto patientDto) {
        return patientDto == null ? null : User.builder()
                .id(patientDto.getId())
//                .name(patientDto.getName())
//                .surname(patientDto.getSurname())
//                .age(patientDto.getAge())
//                .email(patientDto.getEmail())
//                .gender(patientDto.getGender())
//                .enabled(patientDto.getEnabled())
                .build();
    }

    static DoctorDto fromDoctorToDoctorDto(Doctor doctor) {
        return doctor == null ? null : DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
//                .age(doctor.getAge())
//                .email(doctor.getEmail())
                .employmentDate(doctor.getEmploymentDate())
                .experience(doctor.getExperience())
                .specialisations(doctor.getSpecialisations())

//                .gender(doctor.getGender())
                //  .specialisation(doctor.getSpecialisations())
                // .specialisations(doctor.getSpecialisations())
                .photoFilename(doctor.getPhotoFilename())
                .build();
    }

    static Doctor fromDoctorDtoToDoctor(DoctorDto doctorDto) {
        return doctorDto == null ? null : Doctor.builder()

//              .id(doctorDto.getId())
                .name(doctorDto.getName())
                .surname(doctorDto.getSurname())
                .cities(doctorDto.getCities())
                .age(doctorDto.getAge())
                .email(doctorDto.getEmail())
                .employmentDate(doctorDto.getEmploymentDate())
                .experience(doctorDto.getExperience())
                .gender(doctorDto.getGender())
                //  .specialisations(doctorDto.getSpecialisation())
                .photoFilename(doctorDto.getPhotoFilename())
                .password(doctorDto.getPassword())
                .username(doctorDto.getUsername())
                .advices(new HashSet<>())
                .visits(new HashSet<>())
                .build();
    }

    static PatientDto fromPatientToPatientDto(Patient patient) {
        return patient == null ? null : PatientDto.builder()
                .id(patient.getId())
                .age(patient.getAge())
                .visits(patient.getVisits())
                .build();
    }

    static Patient fromPatientDtoToPatient(PatientDto patientDto) {
        return patientDto == null ? null : Patient.builder()
                .id(patientDto.getId())
                .name(patientDto.getName())
                .password(patientDto.getPassword())
                .age(patientDto.getAge())
                .username(patientDto.getUsername())
                .surname(patientDto.getSurname())
                .email(patientDto.getEmail())
                .visits(new HashSet<>())
                .build();
    }

    static Advice fromAdviceDtoToAdvice(AdviceDto adviceDto) {
        return adviceDto == null ? null : Advice.builder()
                .createDate(adviceDto.getCreateDate())
                .description(adviceDto.getDescription())
                .lastModifiedDate(adviceDto.getLastModifiedDate())
                .doctor(adviceDto.getDoctorDto() == null ? null : fromDoctorDtoToDoctor(adviceDto.getDoctorDto()))
                .build();
    }

    static AdviceDto fromAdviceToAdviceDto(Advice advice) {
        return advice == null ? null : AdviceDto.builder()
                .createDate(advice.getCreateDate())
                .lastModifiedDate(advice.getLastModifiedDate())
                .description(advice.getDescription())
                .doctorId(advice.getDoctor().getId())
                .doctorDto(advice.getDoctor() == null ? null : fromDoctorToDoctorDto(advice.getDoctor()))
                .build();
    }

    static Question fromQuestionDtoToQuestion(QuestionDto questionDto) {
        return questionDto == null ? null : Question.builder()
                .description(questionDto.getDescription())
                .patient(questionDto.getPatientDto() == null ? null : fromPatientDtoToPatient(questionDto.getPatientDto()))
                // .patient(questionDto.getPatientDto() == null ? null : fromPatientDtoToPatient(questionDto.getPatientDto()))

                .build();
    }

    static QuestionDto fromQuestionToQuestionDto(Question ask) {
        return ask == null ? null : QuestionDto.builder()
                .description(ask.getDescription())
                .patientDto(ask.getPatient() == null ? null : fromPatientToPatientDto(ask.getPatient()))
                .build();
    }


    static Visit fromVisitDtoToVisit(VisitDto visitDto) {
        return visitDto == null ? null : Visit.builder()
                .id(visitDto.getId())
                .doctor(visitDto.getDoctorDto() == null ? null : fromDoctorDtoToDoctor(visitDto.getDoctorDto()))
//              .patient(visitDto.getPatientDto() == null ? null : fromPatientDtoToPatient(visitDto.getPatientDto()))
                .cost(visitDto.getCost())
                .description(visitDto.getDescription())
                .dateTime(visitDto.getDateTime())
                .build();
    }

    static VisitDto fromVisitDtoToVisit(Visit visit) {
        return visit == null ? null : VisitDto.builder()
                .id(visit.getId())
                .doctorDto(visit.getDoctor() == null ? null : fromDoctorToDoctorDto(visit.getDoctor()))
//              .patient(visit.getPatient() == null ? null : fromPatientToPatientDto(visit.getPatient()))
                .cost(visit.getCost())
                .description(visit.getDescription())
                .dateTime(visit.getDateTime())
                .build();
    }
}

