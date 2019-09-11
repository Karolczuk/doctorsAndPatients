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
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;
    private Boolean enabled;

    

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Transient
    private String passwordConfirmation;

    @Enumerated(EnumType.STRING)
    private Role role;

}


