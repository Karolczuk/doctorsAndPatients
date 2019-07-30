package com.app.doctors_and_patients.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "patients")
public class Patient extends User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;


    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Visit> visits;


    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Question> questions;


//    @Enumerated(EnumType.STRING)
//    private Gender gender;

}
