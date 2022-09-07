package com.example.KeVeo.controller;

import com.example.KeVeo.service.MenuService;
import com.example.KeVeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginControlador extends AbstractController{


    private UserService service;
    @Autowired
    protected LoginControlador(MenuService menuService,UserService service) {
        super(menuService);
        this.service=service;
    }

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
