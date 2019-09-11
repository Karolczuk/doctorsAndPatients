package com.app.doctors_and_patients.validation;

import com.app.doctors_and_patients.dto.DoctorDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class DoctorValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(DoctorDto.class);
    }

    @Override
    public void validate(Object o, Errors errors) {

        DoctorDto doctor = (DoctorDto) o;

        if ( doctor.getName() == null || !doctor.getName().matches("[A-Z]+") ) {
            errors.rejectValue("name", "is not correct");
        }

        if ( doctor.getAge() < 18 ) {
            errors.rejectValue("age", "doctor is not adult");
        }

    }
}
