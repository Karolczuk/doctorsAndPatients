package com.app.doctors_and_patients.dto;

import com.app.doctors_and_patients.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private Gender gender;
}
