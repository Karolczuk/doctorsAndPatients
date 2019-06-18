package com.app.doctors_and_patients.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    // localhost:8080/index
    @GetMapping(value = {"/index", "/"})
    public String index() {
        System.out.println("AAAAA");
        return "index";
    }

}
