package com.app.doctors_and_patients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //włącza listery na klasach bazadoniacwych zeby moc tworzyc funkcje ktore
@SpringBootApplication
public class DoctorsAndPatientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoctorsAndPatientsApplication.class, args);
    }

}
