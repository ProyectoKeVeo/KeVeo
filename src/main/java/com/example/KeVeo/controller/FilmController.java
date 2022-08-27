package com.example.KeVeo.controller;

import com.example.KeVeo.DTO.FilmDTO;
import com.example.KeVeo.DTO.PunctuationDTO;
import com.example.KeVeo.data.entity.FilmEntity;
import com.example.KeVeo.data.entity.GenreEntity;
import com.example.KeVeo.data.entity.PunctuationEntity;
import com.example.KeVeo.data.entity.UserEntity;
import com.example.KeVeo.data.repository.PunctuationRepository;
import com.example.KeVeo.service.*;
import com.example.KeVeo.service.Mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class FilmController extends AbstractController<FilmDTO>{
    @Autowired
    private PunctuationService punctuationService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private UserService userService;

    protected FilmController(MenuService menuService) {
        super(menuService);
    }

    //    @Autowired
//    public FilmController(FilmService filmService,GenreService genreService,FilmMapper filmMapper){
//        this.filmService=filmService;
//        this.genreService=genreService;
//        this.filmMapper=filmMapper;
//
//    }
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

    @GetMapping("/gestionfilms")
    public String listAll2(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                          Model model) {
        PunctuationDTO punctuationDTO= new PunctuationDTO();
        //final UserEntity user = ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Page<FilmDTO> all = this.filmService.findAll(PageRequest.of(page.orElse(1) - 1,
                size.orElse(9)));
        model
                .addAttribute("rating", punctuationDTO)
                .addAttribute("films", all)
                .addAttribute("pageNumbers", getPageNumbers(all));
        return "film/gestionfilms";
    }

    protected List<Integer> getPageNumbers(Page<FilmDTO> pages) {
        return pages.getTotalPages() > 0 ?
                IntStream.rangeClosed(1, pages.getTotalPages()).boxed().collect(Collectors.toList()) :
                new ArrayList<>();
    }

    @GetMapping("/film/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        PunctuationEntity punctuationEntity= new PunctuationEntity();
        model.addAttribute("film", this.filmService.findById(id).get());
        model.addAttribute("rating",this.punctuationService.findById(id).get());
//        model.addAttribute("media", this.filmService.puntuacionMedia(punctuationEntity, id));
        return "film/detail";
    }


    @GetMapping(value = "/film/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        UserEntity principal = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<GenreEntity> listGenres = filmService.listGenres();
        PunctuationDTO punctuationDTO = new PunctuationDTO();
        model.addAttribute("film", this.filmService.findById(id).get());
        model.addAttribute("listGenres", listGenres);
        model.addAttribute("rating",this.punctuationService.PunctuationByFilmIdUserId(id, principal.getId()));
//        PunctuationEntity starsUpdate = punctuationService.getRepository().getOne(id);
//        starsUpdate.setStars(punctuationDTO.getStars());
//        punctuationService.getRepository().save(starsUpdate);
        return "film/edit";
    }

    @GetMapping(value = "/film/create")
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public String create(ModelMap model) {
        FilmDTO filmDTO = new FilmDTO();
        PunctuationDTO punctuationDTO=new PunctuationDTO();
        List<GenreEntity> listGenres = filmService.listGenres();
        model.addAttribute("film", filmDTO);
        model.addAttribute("listGenres", listGenres);
        model.addAttribute("rating",punctuationDTO);

        return "film/edit";
    }

    @Transactional
    @PostMapping(value = {"/film/{id}/edit", "/film/create"})
    public String save(FilmDTO dto, PunctuationDTO ratingDto) {
//        this.punctuationService.save(ratingDto);
        return String.format("redirect:/film/%s/", this.filmService.save(dto).getId());
    }

    @PostMapping(value = {"/film/{id}/delete"})
    public String delete(@PathVariable(value = "id") Integer id) {
        FilmDTO filmDTO = this.filmService.findById(id).get();
        FilmEntity filmEntity= filmService.getServiceMapper().toEntity(filmDTO);
        filmService.getRepository().delete(filmEntity);
        return "redirect:/film";

    }

}
