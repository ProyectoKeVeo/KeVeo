package com.example.KeVeo.controller;

import com.example.KeVeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginControlador {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("errors", true);
        return "login";
    }


}
