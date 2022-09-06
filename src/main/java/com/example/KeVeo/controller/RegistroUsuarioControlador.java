package com.example.KeVeo.controller;

import com.example.KeVeo.DTO.UserDTO;
import com.example.KeVeo.service.MenuService;
import com.example.KeVeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;


@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador extends AbstractController{

    @Autowired
    private UserService userService;

    protected RegistroUsuarioControlador(MenuService menuService) {
        super(menuService);
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


        userService.registerDefaultUser(registroDTO);
        return "redirect:/registro?exito";
    }


}
