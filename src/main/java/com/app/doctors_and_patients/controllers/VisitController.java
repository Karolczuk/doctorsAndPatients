package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.dto.PatientDto;
import com.app.doctors_and_patients.dto.VisitDto;
import com.app.doctors_and_patients.model.Gender;
import com.app.doctors_and_patients.service.VisitService;
import lombok.RequiredArgsConstructor;
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
    private  final VisitService visitService;
    @GetMapping("/add")
    public String addGet(Model model) {
        model.addAttribute("visit", new VisitDto());
        return "visit/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute VisitDto visitDto) {
        visitService.add(visitDto);
        return "redirect:/";
    }
}
