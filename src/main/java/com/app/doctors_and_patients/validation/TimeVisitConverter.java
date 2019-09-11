package com.app.doctors_and_patients.validation;

import com.app.doctors_and_patients.dto.TimeVisitDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import java.io.IOException;

@Slf4j //dodaje log
public class TimeVisitConverter implements AttributeConverter<TimeVisitDto, String> {


    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(TimeVisitDto timeVisitDto) {
        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(timeVisitDto);
        } catch (final JsonProcessingException e) {
            log.error("JSON writing error", e);
        }

        return customerInfoJson;
    }

    @Override
    public TimeVisitDto convertToEntityAttribute(String s) {

        TimeVisitDto timeVisitDto = null;
        try {
            timeVisitDto = objectMapper.readValue(s, TimeVisitDto.class);
        } catch (final IOException e) {
            log.error("JSON reading error", e);
        } catch (NullPointerException e){
            log.warn("object in database doe not exist");
        }
        return timeVisitDto;
    }
}
