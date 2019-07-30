package com.app.doctors_and_patients.service;
import com.app.doctors_and_patients.dto.VisitDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    public void add(VisitDto visitDto) {

        if (visitDto == null) {
            throw new AppException("visit is null");
        }


        System.out.println("visitDto" +visitDto);
        visitRepository.save(ModelMapper.fromVisitDtoToVisit(visitDto));
    }
}
