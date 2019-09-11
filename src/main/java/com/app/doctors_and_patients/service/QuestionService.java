package com.app.doctors_and_patients.service;

import com.app.doctors_and_patients.domain.Patient;
import com.app.doctors_and_patients.domain.Question;
import com.app.doctors_and_patients.dto.QuestionDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.repository.PatientRepository;
import com.app.doctors_and_patients.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    public final QuestionRepository questionRepository;
    private final PatientRepository patientRepository;

    public void add(QuestionDto questionDto) {
        if (questionDto == null) {
            throw new AppException("QuestionDto is null");
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Patient> patient = patientRepository.findByUsername(username);

        Question question = ModelMapper.fromQuestionDtoToQuestion(questionDto);

        if (patient.isPresent()) {
            question.setPatient(patient.get());
            questionRepository.save(question);
        }
    }

}
