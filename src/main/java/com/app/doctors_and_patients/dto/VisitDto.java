package com.app.doctors_and_patients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitDto {
    private Long id;
    private DoctorDto doctorDto;
    private PatientDto patientDto;
    private BigDecimal cost;
    private LocalDate dateTime;
}
