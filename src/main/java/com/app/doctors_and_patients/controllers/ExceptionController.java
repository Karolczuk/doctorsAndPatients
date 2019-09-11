package com.app.doctors_and_patients.controllers;

import com.app.doctors_and_patients.exception.AppException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AppException.class)
    public String error(AppException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "exceptions/appException";
    }

    @ExceptionHandler(Exception.class)
    public String otherExceptions(Model model, Exception e) {
        model.addAttribute("message", e.getMessage());
        return "exceptions/exception";
    }

}
