package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.dto.PatientDto;
import com.app.doctors_and_patients.dto.VisitDto;
import com.app.doctors_and_patients.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/add/{doctorId}")
    public String addGet(Model model, @PathVariable Long doctorId) {
        model.addAttribute("visit", VisitDto.builder().doctorId(doctorId).build());
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


    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/setSchedule")
    public String setSchedule(Model model) {
        model.addAttribute("visit", new VisitDto());
        model.addAttribute("doctor", new DoctorDto());
        return "visits/schedule";
    }

    @PostMapping("/setSchedule")
    public String setSchedule(@ModelAttribute VisitDto visitDto) {
        visitService.add(visitDto);
        return "redirect:/";
    }

}
