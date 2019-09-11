package com.app.doctors_and_patients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdviceDto {


    private Long id;

    private LocalDateTime createDate;

    private LocalDateTime lastModifiedDate;

    private String description;

    private DoctorDto doctorDto;

    private Long doctorId;
}
