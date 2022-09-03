package com.example.KeVeo.controller;

import com.example.KeVeo.DTO.FilmDTO;
import com.example.KeVeo.data.entity.FilmEntity;
import com.example.KeVeo.data.entity.GenreEntity;
import com.example.KeVeo.service.FilmService;
import com.example.KeVeo.service.GenreService;
import com.example.KeVeo.service.Mapper.FilmMapper;
import com.example.KeVeo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    private FilmService filmService;
    private GenreService genreService;
    private FilmMapper filmMapper;
    @Autowired
    protected FilmController(MenuService menuService,FilmService filmService,GenreService genreService,FilmMapper filmMapper) {
        super(menuService);
        this.filmService=filmService;
        this.genreService=genreService;
        this.filmMapper=filmMapper;
    }

    @GetMapping("/film")
    public String listAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                          Model model) {
        //final UserEntity user = ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Page<FilmDTO> listFilms = this.filmService.findAll(PageRequest.of(page.orElse(1) - 1,
                size.orElse(12)));
        model
                .addAttribute("listFilms", listFilms)
                .addAttribute("pageNumbers", getPageNumbers(listFilms));
        return "film/list";
    }

    @GetMapping("/gestionfilms")
    public String listAll2(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                          Model model) {
        //final UserEntity user = ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Page<FilmDTO> all = this.filmService.findAll(PageRequest.of(page.orElse(1) - 1,
                size.orElse(9)));
        model
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
        model.addAttribute("film", this.filmService.findById(id).get());
        return "film/detail";
    }

    @GetMapping(value = "/film/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        List<GenreEntity> listGenres = filmService.listGenres();
        model.addAttribute("film", this.filmService.findById(id).get());
        model.addAttribute("listGenres", listGenres);
        return "film/edit";
    }

    @GetMapping(value = "/film/create")
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public String create(ModelMap model) {
        FilmDTO filmDTO = new FilmDTO();
        List<GenreEntity> listGenres = filmService.listGenres();
        model.addAttribute("film", filmDTO);
        model.addAttribute("listGenres", listGenres);

        return "film/edit";
    }

    @Transactional
    @PostMapping(value = {"/film/{id}/edit", "/film/create"})
    public String save(FilmDTO dto) {
        return String.format("redirect:/film/%s", this.filmService.save(dto).getId());
    }

    @PostMapping(value = {"/film/{id}/delete"})
    public String delete(@PathVariable(value = "id") Integer id) {
        FilmDTO filmDTO = this.filmService.findById(id).get();
        FilmEntity filmEntity= filmMapper.toEntity(filmDTO);
        filmService.getRepository().delete(filmEntity);
        return "redirect:/film";

    }

    @GetMapping("/film/filmInfo/{id}")
    public String viewInfo(@PathVariable("id") Integer id, ModelMap model) {
        /*Integer userId ;
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            userId=3;
        }else userId=((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        User user = userRepository.findById(userId).get();
        CommentDTO commentDTO=new CommentDTO();*/
        FilmDTO filmDTO = filmService.findById(id).get();
        FilmEntity film= filmMapper.toEntity(filmDTO);
        //List<CommentDTO> listComments= commentService.findByFilmId(id);
        model
                .addAttribute("film", film);
                //.addAttribute("listComments",listComments)
                //.addAttribute("user",user)
                //.addAttribute("comment", commentDTO);

        return "film/filmInfo";
    }
}
