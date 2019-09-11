package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.dto.DoctorDto;
import com.app.doctors_and_patients.domain.City;
import com.app.doctors_and_patients.domain.Gender;
import com.app.doctors_and_patients.domain.Specialisation;
import com.app.doctors_and_patients.service.DoctorService;

import com.app.doctors_and_patients.validation.DoctorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorValidator doctorValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(doctorValidator);
    }

  //  @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/add")
    public String addGet(Model model) {
        model.addAttribute("errors", new HashMap<>());
        model.addAttribute("doctor", new DoctorDto());
        model.addAttribute("cities", City.values());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("specialisation", Specialisation.values());
        model.addAttribute("experiences", List.of(1, 2, 3, 5, 10, 15));
        return "doctors/add";
    }


    @PostMapping("/add")
    public String add(
            @Valid @ModelAttribute DoctorDto doctor,
            BindingResult bindingResult,
            Model model ) {

        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(e -> System.out.println(e.getField() + " " + e.getDefaultMessage()));
            model.addAttribute("errors", bindingResult
                    .getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(
                            FieldError::getField,
                            // FieldError::getDefaultMessage, -> HIBERNATE
                            FieldError::getCode, // -> SPRING
                            (err1, err2) -> err1 + ", " + err2
                    )));
            model.addAttribute("doctor", new DoctorDto());
            model.addAttribute("cities", City.values());
            model.addAttribute("genders", Gender.values());
            model.addAttribute("specialisation", Specialisation.values());
            model.addAttribute("experiences", List.of(1, 2, 3, 5, 10, 15));
            return "doctors/add";
        }


        doctorService.add(doctor);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchSpecialisationGet(Model model) {
        model.addAttribute("doctor", new DoctorDto());
        model.addAttribute("specialisation", Specialisation.values());
        model.addAttribute("cities", City.values());
        return "index";
    }

    @PostMapping("/search")
    public String searchSpecialisation(@ModelAttribute DoctorDto doctorDto, BindingResult bindingResult, Model model) {
        // model.addAttribute("doctors", doctorService.findBySpecialisaton(Arrays.asList(doctorDto.getSpecialisation()), Arrays.asList(doctorDto.getCity())));
        return "doctors/list";
    }

    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable Long id, Model model) {
        model.addAttribute("errors", new HashMap<>());
        model.addAttribute("cities", City.values());
        model.addAttribute("specialisation", Specialisation.values());
        model.addAttribute("experiences", List.of(1, 2, 3, 5, 10, 15));
        model.addAttribute("doctor", doctorService.findOne(id));
        return "doctors/update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute DoctorDto doctorDto) {
        doctorService.update(doctorDto);
        return "redirect:/";
    }


    @PostMapping("/delete")
    public String deletePost(@RequestParam Long id) {
        doctorService.delete(id);
        return "redirect:/";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }


}
