package com.school.SchoolApp.controller;

import com.school.SchoolApp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.school.SchoolApp.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model, HttpServletRequest request) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        model.addAttribute("_csrf", csrfToken);
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model, HttpServletRequest request) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        model.addAttribute("_csrf", csrfToken);
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            log.info("Attempting to register new user: {}", user.getUsername());
            userService.registerUser(user);
            log.info("User registered successfully: {}", user.getUsername());
            return "redirect:/login?registered";
        } catch (Exception e) {
            log.error("Error registering user: {}", e.getMessage(), e);
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "register";
        }
    }
}