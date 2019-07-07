package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.domain.City;
import com.app.doctors_and_patients.domain.Specialisation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

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




    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("log_in")
    public String log_in() {
        return "log_in";
    }

    @GetMapping(value = {"questions"})
    public String questions() {
        return "questions";
    }



}
