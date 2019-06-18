package com.app.doctors_and_patients.dto;

import com.app.doctors_and_patients.model.Gender;
import com.app.doctors_and_patients.model.Specialisation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDto {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate employmentDate;
    private Integer experience;
    private Gender gender;
    private Set<Specialisation> specialisations;
    private String photoFilename;
    private MultipartFile file;

}
