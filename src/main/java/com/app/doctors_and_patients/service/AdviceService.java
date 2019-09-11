package com.app.doctors_and_patients.service;


import com.app.doctors_and_patients.domain.Advice;
import com.app.doctors_and_patients.domain.Doctor;
import com.app.doctors_and_patients.dto.AdviceDto;
import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.exception.AppException;
import com.app.doctors_and_patients.repository.AdviceRepository;
import com.app.doctors_and_patients.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdviceService {

    public final AdviceRepository adviceRepository;
    public final DoctorRepository doctorRepository;

    public void addAdvice(AdviceDto adviceDto) {
        if (adviceDto == null) {
            throw new AppException("AdviceDto is null");
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Doctor> doctor = doctorRepository.findByUsername(username);

        Advice advice = ModelMapper.fromAdviceDtoToAdvice(adviceDto);

        if (doctor.isPresent()) {
            advice.setDoctor(doctor.get());
            adviceRepository.save(advice);
        }
    }

    public AdviceDto findOne(Long id) {

        if (id == null) {
            throw new AppException("Advice service - find one - id is null");
        }

        return adviceRepository
                .findById(id)
                .map(ModelMapper::fromAdviceToAdviceDto)
                .orElseThrow(() -> new AppException("No advice with id " + id));
    }

    public AdviceDto update(AdviceDto adviceDto) {

        if (adviceDto.getId() == null) {
            throw new AppException("Advice service - update - id is null");
        }

        return adviceRepository
                .findById(adviceDto.getId())
                .map(adviceFromDb -> {

                    adviceFromDb.setDescription(adviceDto.getDescription() == null ? adviceFromDb.getDescription() : adviceDto.getDescription());

                    return ModelMapper.fromAdviceToAdviceDto(adviceRepository.save(adviceFromDb));
                }).orElseThrow(() -> new AppException("Advice service - update - cannot update advice with id " + adviceDto.getId()));
    }


    public AdviceDto delete(Long id) {

        if (id == null) {
            throw new AppException("Advice service - delete - id is null");
        }

        Advice advice = adviceRepository.findById(id).orElseThrow(() -> new AppException("Advice service - delete - no advice with id " + id));
        adviceRepository.deleteById(id);
        return ModelMapper.fromAdviceToAdviceDto(advice);
    }
}
