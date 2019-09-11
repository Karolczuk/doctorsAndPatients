package com.app.doctors_and_patients.service;

import com.app.doctors_and_patients.domain.Doctor;
import com.app.doctors_and_patients.domain.Patient;
import com.app.doctors_and_patients.domain.Visit;
import com.app.doctors_and_patients.dto.VisitDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.repository.DoctorRepository;
import com.app.doctors_and_patients.repository.PatientRepository;
import com.app.doctors_and_patients.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public void add(VisitDto visitDto) {

        if (visitDto == null) {
            throw new AppException("visit is null");
        }

        Optional<Doctor> doctorOptional = doctorRepository.findById(visitDto.getDoctorId());

        Optional<Patient> patientOptional = patientRepository.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());

        doctorOptional.ifPresent(doctor -> patientOptional.ifPresent(
                patient -> {
                    if (visitDto.getDateTime().getDayOfWeek().toString().equalsIgnoreCase(
                            "Monday") && doctor.getTimeVisit().isMonday()
                            && (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getMondayFrom()))
                            || visitDto.getLocalTime().isAfter(LocalTime.parse(
                            doctor.getTimeVisit().getMondayFrom())))
                            &&
                            (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getMondayTo()))
                                    || visitDto.getLocalTime().isBefore(LocalTime.parse(
                                    doctor.getTimeVisit().getMondayTo())))

                    ) {
                        if (doctor.getVisits()
                                .stream()
                                .filter(s -> s.getDateTime().equals(visitDto.getDateTime()))
                                .noneMatch(s -> s.getLocalTime().equals(visitDto.getLocalTime()) || (visitDto.getLocalTime().isAfter(s.getLocalTime()) && visitDto.getLocalTime().isBefore(s.getLocalTime().plusHours(1)))))

                            visitRepository.save(Visit.builder().doctor(doctor).patient(patient).dateTime(visitDto.getDateTime()).localTime(visitDto.getLocalTime()).build());


                    } else if (visitDto.getDateTime().getDayOfWeek().toString().equalsIgnoreCase(
                            "Tuesday") && doctor.getTimeVisit().isTuesday()
                            && (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getTuesdayFrom()))
                            || visitDto.getLocalTime().isAfter(LocalTime.parse(
                            doctor.getTimeVisit().getTuesdayFrom())))
                            &&
                            (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getMondayTo()))
                                    || visitDto.getLocalTime().isBefore(LocalTime.parse(
                                    doctor.getTimeVisit().getTuesdayTo())))

                    ) {
                        visitRepository.save(Visit.builder().doctor(doctor).patient(patient).dateTime(visitDto.getDateTime()).localTime(visitDto.getLocalTime()).build());

                    } else if (visitDto.getDateTime().getDayOfWeek().toString().equalsIgnoreCase(
                            "Wendsday") && doctor.getTimeVisit().isWendsday()
                            && (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getWendsdayFrom()))
                            || visitDto.getLocalTime().isAfter(LocalTime.parse(
                            doctor.getTimeVisit().getWendsdayFrom())))
                            &&
                            (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getWendsdayTo()))
                                    || visitDto.getLocalTime().isBefore(LocalTime.parse(
                                    doctor.getTimeVisit().getWendsdayTo())))

                    ) {
                        visitRepository.save(Visit.builder().doctor(doctor).patient(patient).dateTime(visitDto.getDateTime()).localTime(visitDto.getLocalTime()).build());


                    } else if (visitDto.getDateTime().getDayOfWeek().toString().equalsIgnoreCase(
                            "Thursday") && doctor.getTimeVisit().isThursday()
                            && (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getThursdayFrom()))
                            || visitDto.getLocalTime().isAfter(LocalTime.parse(
                            doctor.getTimeVisit().getThursdayFrom())))
                            &&
                            (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getThursdayTo()))
                                    || visitDto.getLocalTime().isBefore(LocalTime.parse(
                                    doctor.getTimeVisit().getThursdayTo())))

                    ) {
                        visitRepository.save(Visit.builder().doctor(doctor).patient(patient).dateTime(visitDto.getDateTime()).localTime(visitDto.getLocalTime()).build());


                    } else if (visitDto.getDateTime().getDayOfWeek().toString().equalsIgnoreCase(
                            "Monday") && doctor.getTimeVisit().isFriday()
                            && (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getFridayFrom()))
                            || visitDto.getLocalTime().isAfter(LocalTime.parse(
                            doctor.getTimeVisit().getFridayFrom())))
                            &&
                            (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getFridayTo()))
                                    || visitDto.getLocalTime().isBefore(LocalTime.parse(
                                    doctor.getTimeVisit().getFridayTo())))

                    ) {
                        visitRepository.save(Visit.builder().doctor(doctor).patient(patient).dateTime(visitDto.getDateTime()).localTime(visitDto.getLocalTime()).build());


                    } else if (visitDto.getDateTime().getDayOfWeek().toString().equalsIgnoreCase(
                            "Monday") && doctor.getTimeVisit().isSaturday()
                            && (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getSaturdayFrom()))
                            || visitDto.getLocalTime().isAfter(LocalTime.parse(
                            doctor.getTimeVisit().getSaturdayFrom())))
                            &&
                            (visitDto.getLocalTime().equals(LocalTime.parse(doctor.getTimeVisit().getSaturdayTo()))
                                    || visitDto.getLocalTime().isBefore(LocalTime.parse(
                                    doctor.getTimeVisit().getSaturdayTo())))

                    ) {

                        visitRepository.save(Visit.builder().doctor(doctor).patient(patient).dateTime(visitDto.getDateTime()).localTime(visitDto.getLocalTime()).build());
                    }
                }
                )

        );


    }
}


