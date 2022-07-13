package com.example.KeVeo.controller;

import com.example.KeVeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegistroControlador {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute("usuarios", service.listarUsuarios());
        return "index";
    }
}
