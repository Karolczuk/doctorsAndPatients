package com.app.doctors_and_patients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class QuestionDto {

    private Long id;
    private String description;
    private PatientDto patientDto;
}

