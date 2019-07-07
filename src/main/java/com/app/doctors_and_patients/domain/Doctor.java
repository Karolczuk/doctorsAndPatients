package com.app.doctors_and_patients.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;
    private String email;
    private Integer age;
    private LocalDate employmentDate;
    private Integer experience;
    private String photoFilename;

    @Enumerated(EnumType.STRING)
    private Gender gender;

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
