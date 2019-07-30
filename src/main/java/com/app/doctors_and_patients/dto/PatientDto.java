package com.app.doctors_and_patients.dto;

import com.app.doctors_and_patients.domain.Question;
import com.app.doctors_and_patients.domain.Visit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    private String username;
    private String password;
    private String passwordConfirmation;


    private Set<Visit> visits;
    private Set<Question> asks;

}
