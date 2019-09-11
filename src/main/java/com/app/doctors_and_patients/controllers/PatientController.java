package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.domain.Gender;
import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.dto.PatientDto;
import com.app.doctors_and_patients.dto.QuestionDto;
import com.app.doctors_and_patients.dto.VisitDto;
import com.app.doctors_and_patients.service.PatientService;
import com.app.doctors_and_patients.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {



    private final PatientService patientService;

   // @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/add")
    public String addGet(Model model) {
        model.addAttribute("patient", new PatientDto());
        return "patients/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute PatientDto patientDto) {
        patientService.add(patientDto);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable Long id,  Model model) {
        model.addAttribute("errors", new HashMap<>());
        model.addAttribute("patient", patientService.findOne(id));
        //model.addAttribute("genders", Gender.values());
        return "patients/update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute PatientDto patientDto) {
        patientService.update(patientDto);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deletePost(@RequestParam Long id) {
        patientService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("log_in")
    public String log_in() {
        return "log_in";
    }


}
