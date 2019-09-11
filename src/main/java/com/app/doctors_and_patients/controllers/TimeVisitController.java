package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.dto.TimeVisitDto;
import com.app.doctors_and_patients.service.TimeVisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/time-visits")
public class TimeVisitController {

    private final TimeVisitService timeVisitService;

    @PostMapping("/add")
    public String add(@ModelAttribute @Valid TimeVisitDto timeVisitDto) {
        timeVisitService.add(timeVisitDto);

        System.out.println("timeVisit" + timeVisitDto.toString());
        return "redirect:/";
    }

    @GetMapping("/add/{id}")
    public String addGet(Model model, @PathVariable Long id) {
        model.addAttribute("timeVisit", TimeVisitDto.builder().doctorId(id).build());
        return "visits/schedule";
    }
}
