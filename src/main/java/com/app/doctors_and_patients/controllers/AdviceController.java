package com.app.doctors_and_patients.controllers;


import com.app.doctors_and_patients.dto.AdviceDto;
import com.app.doctors_and_patients.service.AdviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequiredArgsConstructor
@RequestMapping("/advice")
public class AdviceController {
    private final AdviceService adviceService;

    @PostMapping("/add")
    //@PreAuthorize("isAuthenticated()")
    public String add(@ModelAttribute AdviceDto adviceDto) {
        adviceService.addAdvice(adviceDto);
        return "redirect:/";
    }

    @GetMapping("/add")
    //@PreAuthorize("isAuthenticated()")
    @PreAuthorize("hasRole('DOCTOR')")
    public String addGet( Model model) {
        model.addAttribute("advice", new AdviceDto());
        return "advice/add";
    }


}
