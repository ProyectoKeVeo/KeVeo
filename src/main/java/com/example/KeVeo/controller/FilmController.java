package com.example.KeVeo.controller;

import com.example.KeVeo.DTO.FilmDTO;
import com.example.KeVeo.DTO.GenreDTO;
import com.example.KeVeo.data.entity.GenreEntity;
import com.example.KeVeo.service.FilmService;
import com.example.KeVeo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class FilmController {
    @Autowired
    private FilmService filmService;
    private GenreService genreService;

    @GetMapping("/film")
    public String listAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                          Model model) {
        //final UserEntity user = ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Page<FilmDTO> all = this.filmService.findAll(PageRequest.of(page.orElse(1) - 1,
                size.orElse(9)));
        model
                .addAttribute("films", all)
                .addAttribute("pageNumbers", getPageNumbers(all));
        return "film/list";
    }

    protected List<Integer> getPageNumbers(Page<FilmDTO> pages) {
        return pages.getTotalPages() > 0 ?
                IntStream.rangeClosed(1, pages.getTotalPages()).boxed().collect(Collectors.toList()) :
                new ArrayList<>();
    }

    @GetMapping("/film/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("film", this.filmService.findById(id).get());
        return "film/detail";
    }
    @GetMapping(value = "/film/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("film", this.filmService.findById(id).get());

        return "film/edit";
    }
    @Transactional
    @PostMapping(value = { "/film/{id}/edit", "/film/create" })
    public String save(FilmDTO dto, GenreDTO genreDTO) {
        return String.format("redirect:/film/%s", this.filmService.save(dto).getId());
    }
}
