package com.app.doctors_and_patients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DoctorsAndPatientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoctorsAndPatientsApplication.class, args);
    }

}
