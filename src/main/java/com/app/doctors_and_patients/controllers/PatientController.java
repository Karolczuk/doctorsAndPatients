package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.dto.PatientDto;
import com.app.doctors_and_patients.model.Gender;
import com.app.doctors_and_patients.service.PatientService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/add")
    public String addGet(Model model) {
        model.addAttribute("patient", new PatientDto());
        model.addAttribute("genders", Gender.values());
        return "patients/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute PatientDto patientDto) {
        patientService.add(patientDto);
        return "redirect:/";
    }

}
