package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.domain.City;
import com.app.doctors_and_patients.domain.Gender;
import com.app.doctors_and_patients.domain.Specialisation;
import com.app.doctors_and_patients.service.DoctorService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/add")
    public String addGet(Model model) {
        model.addAttribute("doctor", new DoctorDto());
        model.addAttribute("cities", City.values());
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

    @GetMapping("/search")
    public String searchSpecialisationGet(Model model) {
        model.addAttribute("doctor", new DoctorDto());
        model.addAttribute("specialisations", Specialisation.values());
        model.addAttribute("cities", City.values());
        return "index";
    }

    @PostMapping("/search")
    public String searchSpecialisation(@ModelAttribute DoctorDto doctorDto, BindingResult bindingResult, Model model) {
        model.addAttribute("doctors", doctorService.findBySpecialisaton(Arrays.asList(doctorDto.getSpecialisation()), Arrays.asList(doctorDto.getCity())));
        return "doctors/list";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


}
