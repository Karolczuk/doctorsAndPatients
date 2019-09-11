package com.app.doctors_and_patients.domain;

import com.app.doctors_and_patients.dto.TimeVisitDto;
import com.app.doctors_and_patients.validation.TimeVisitConverter;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

@Entity
@Table(name = "doctors")
public class Doctor extends User {



    private LocalDate employmentDate;
    private Integer experience;


    private String photoFilename;

    @Lob 
    @Convert(converter = TimeVisitConverter.class) 
    private TimeVisitDto timeVisit;



    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Visit> visits;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "specialisations",
            joinColumns = @JoinColumn(name = "doctor_id")
    )
    @Column(name = "specialisation")
    private Set<Specialisation> specialisations;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "cities",
            joinColumns = @JoinColumn(name = "doctor_id")
    )
    @Column(name = "city")
    private Set<City> cities;

    @OneToMany(mappedBy = "doctor", orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Advice> advices;

}
