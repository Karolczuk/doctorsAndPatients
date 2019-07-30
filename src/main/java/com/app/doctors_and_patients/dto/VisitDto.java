package com.app.doctors_and_patients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitDto {

    private Long id;
    private BigDecimal cost;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTime;

    private DoctorDto doctorDto;
    private String description;

}
