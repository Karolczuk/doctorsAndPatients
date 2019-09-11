package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.domain.City;
import com.app.doctors_and_patients.domain.Specialisation;
import com.app.doctors_and_patients.dto.DoctorDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Main {



    // localhost:8080/index
    @GetMapping(value = {"/index", "/"})
    public String index(Model model) {
        model.addAttribute("doctor", new DoctorDto());
        model.addAttribute("specialisations", Specialisation.values());
        model.addAttribute("cities", City.values());
        model.addAttribute("photo","5ea4dddc-c70c-434e-8e92-f89d9c9d50d7.jpg" );
        System.out.println("AAAAA");
        return "index";
    }

    @GetMapping(value = {"questions"})
    public String questions() {
        return "questions";
    }

    @GetMapping("/notFound")
    public String notFoundException(Model model) {
        model.addAttribute("message", "Page not found!");
        return "exceptions/exception";
    }
}
