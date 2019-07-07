package com.app.doctors_and_patients.service;


import com.app.doctors_and_patients.domain.Advice;
import com.app.doctors_and_patients.domain.Doctor;
import com.app.doctors_and_patients.dto.AdviceDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.repository.AdviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdviceService {

    public final AdviceRepository adviceRepository;

    public void addAdvice(AdviceDto adviceDto) {
        if (adviceDto == null) {
            throw new AppException("AdviceDto is null");
        }

        Advice advice = ModelMapper.fromAdviceDtoToAdvice(adviceDto);
        adviceRepository.save(advice);
    }
}
