package com.example.KeVeo.controller;

import com.example.KeVeo.dto.UserDTO;
import com.example.KeVeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;


@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UserService userService;

    public RegistroUsuarioControlador(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("usuario")
    public UserDTO retornarNuevoUsuarioRegistroDTO() {
        return new UserDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UserDTO registroDTO) throws ParseException {
        userService.guardar(registroDTO);
        return "redirect:/registro?exito";
    }
}
