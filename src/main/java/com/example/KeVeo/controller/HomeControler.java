package com.example.KeVeo.controller;

import com.example.KeVeo.DTO.FilmDTO;
import com.example.KeVeo.data.entity.GenreEntity;
import com.example.KeVeo.service.FilmService;
import com.example.KeVeo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeControler extends AbstractController{

    private FilmService filmService;
    @Autowired
    protected HomeControler(MenuService menuService,FilmService filmService) {
        super(menuService);
        this.filmService=filmService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {

        final List<FilmDTO> listFilmsYear=this.filmService.findByYear();
        final List<FilmDTO> listFilmsIdDesc=this.filmService.findByIdDesc();
        model
                .addAttribute("listFilmsIdDesc", listFilmsIdDesc)
                .addAttribute("listFilmsYear", listFilmsYear);
        return "home";
    }

}
