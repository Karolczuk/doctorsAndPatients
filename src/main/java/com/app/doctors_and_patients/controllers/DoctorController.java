package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.model.Gender;
import com.app.doctors_and_patients.model.Specialisation;
import com.app.doctors_and_patients.service.DoctorService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/add")
    public String addGet(Model model) {
        model.addAttribute("doctor", new DoctorDto());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("specialisation", Specialisation.values());
        model.addAttribute("experiences", List.of(1, 2, 3, 5, 10, 15));
        return "doctors/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute DoctorDto doctorDto) {
        doctorService.add(doctorDto);
        return "redirect:/";
    }
//    @PostMapping("/add")
//    public String addPost(@ModelAttribute WorkerDto worker) {
//        System.out.println(worker);
//        // workerService.add(worker);
//        return "redirect:/";
//    }

}
