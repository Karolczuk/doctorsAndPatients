package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.dto.PatientDto;
import com.app.doctors_and_patients.dto.VisitDto;
import com.app.doctors_and_patients.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;

    //@PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/add")
    public String addGet(Model model) {
        model.addAttribute("visit", new VisitDto());
        model.addAttribute("doctor", new DoctorDto());
        return "visits/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute VisitDto visitDto) {
        visitService.add(visitDto);
        return "redirect:/";
    }

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/visit")
    public String visitGet(Model model) {
        model.addAttribute("visit", new VisitDto());
        model.addAttribute("patient", new PatientDto());
        return "visits/visit";
    }

    @PostMapping("/visit")
    public String visit(@ModelAttribute PatientDto patientDto) {
        return "redirect:/";
    }

}
