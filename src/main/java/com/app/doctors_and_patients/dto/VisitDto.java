package com.app.doctors_and_patients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitDto {

    private Long id;
    private BigDecimal cost;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTime;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime localTime;
    private DoctorDto doctorDto;
    private Long doctorId;
    private Long patientId;

    private String description;

}
