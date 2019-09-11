package com.app.doctors_and_patients.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY) // nie zapisuje do bd pustych wartosci
public class TimeVisitDto {

    private boolean monday;
    private boolean tuesday;
    private boolean wendsday;
    private boolean thursday;
    private boolean friday;
    private boolean saturday;


    private Long doctorId;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String mondayTo;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String mondayFrom;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String tuesdayTo;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String tuesdayFrom;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String wendsdayTo;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String wendsdayFrom;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String thursdayTo;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String thursdayFrom;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String fridayTo;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String fridayFrom;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String saturdayTo;

    @Pattern(regexp = "((?:[01]\\d|2[0123]):(?:[012345]\\d))?")
    private String saturdayFrom;


 ;



}
