package com.app.doctors_and_patients.controllers;
import com.app.doctors_and_patients.domain.User;
import com.app.doctors_and_patients.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
@RequiredArgsConstructor
public class SecurityController {

    private final UserService userService;

    @GetMapping("/register")
    public String registerUserGet(Model model) {
        model.addAttribute("user", new User());
        return "security/register";
    }

    @PostMapping("/register")
    public String registerUserPost(@ModelAttribute User user) {
        userService.register(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("error", "");
        return "security/login";
    }

    @GetMapping("/loginError")
    public String loginError(Model model) {
        model.addAttribute("error", "Bad credentials");
        return "security/login";
    }
}
