package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.dto.QuestionDto;
import com.app.doctors_and_patients.service.QuestionService;
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
@RequestMapping("/questions")
public class QuestionController {


    private final QuestionService questionService;

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/add")
    public String addGet(Model model) {
        model.addAttribute("question", new QuestionDto());
        return "question";
    }

    @PreAuthorize("hasRole('PATIENT')")
    @PostMapping("/add")
    public String add(@ModelAttribute QuestionDto questionDto) {
        questionService.add(questionDto);
        return "redirect:/";
    }

}
