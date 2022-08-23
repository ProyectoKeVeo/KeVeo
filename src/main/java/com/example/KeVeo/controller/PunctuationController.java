package com.example.KeVeo.controller;

import com.example.KeVeo.DTO.PunctuationDTO;
import com.example.KeVeo.service.FilmService;
import com.example.KeVeo.service.MenuService;
import com.example.KeVeo.service.PunctuationService;
import com.example.KeVeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class PunctuationController extends AbstractController<PunctuationDTO>{
    @Autowired
    private FilmService filmService;
    @Autowired
    private PunctuationService punctuationService;
    @Autowired
    private UserService userService;
    protected PunctuationController(MenuService menuService) {
        super(menuService);
    }
}
