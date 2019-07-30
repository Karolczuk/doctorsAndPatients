package com.app.doctors_and_patients.service;

import com.app.doctors_and_patients.domain.Question;
import com.app.doctors_and_patients.dto.QuestionDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    public final QuestionRepository questionRepository;

    public void add(QuestionDto questionDto) {
        if (questionDto == null) {
            throw new AppException("QuestionDto is null");
        }

        Question question= ModelMapper.fromQuestionDtoToQuestion(questionDto);
        questionRepository.save(question);
    }

}
