package com.example.KeVeo.controller;

import com.example.KeVeo.DTO.CommentDTO;
import com.example.KeVeo.DTO.FilmDTO;
import com.example.KeVeo.DTO.PunctuationDTO;
import com.example.KeVeo.DTO.UrlDTO;
import com.example.KeVeo.data.entity.FilmEntity;
import com.example.KeVeo.data.entity.GenreEntity;
import com.example.KeVeo.data.entity.PunctuationEntity;
import com.example.KeVeo.data.entity.UserEntity;
import com.example.KeVeo.data.repository.PunctuationRepository;
import com.example.KeVeo.data.repository.UserRepository;
import com.example.KeVeo.service.*;
import com.example.KeVeo.service.Mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentService commentService;
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private UrlService urlService;
    protected FilmController(MenuService menuService,FilmService filmService,GenreService genreService,FilmMapper filmMapper) {
        super(menuService);
        this.filmService=filmService;
        this.genreService=genreService;
        this.filmMapper=filmMapper;
    }

    @GetMapping("/film")
    public String listAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                          Model model, @Param("keyWord") String keyWord) {
        //final UserEntity user = ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        List<GenreEntity> listGenres = genreService.listGenres();
        Page<FilmDTO> listFilms = this.filmService.findAll(keyWord, PageRequest.of(page.orElse(1) - 1,
                size.orElse(12)));
        model
                .addAttribute("keyWord", keyWord)
                .addAttribute("listGenres", listGenres)
                .addAttribute("listFilms", listFilms)
                .addAttribute("pageNumbers", getPageNumbers(listFilms));
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
//				.addAttribute("rating", punctuationDTO)
                .addAttribute("films", all)
                .addAttribute("pageNumbers", getPageNumbers(all));
        return "film/gestionfilms";
    }

    protected List<Integer> getPageNumbers(Page<FilmDTO> pages) {
        return pages.getTotalPages() > 0 ?
                IntStream.rangeClosed(1, pages.getTotalPages()).boxed().collect(Collectors.toList()) :
                new ArrayList<>();
    }



    @GetMapping(value = "/film/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        UserEntity principal = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<GenreEntity> listGenres = genreService.listGenres();
        PunctuationDTO punctuationDTO = new PunctuationDTO();
        model.addAttribute("film", this.filmService.findById(id).get());
        model.addAttribute("listGenres", listGenres);
//        model.addAttribute("rating",this.punctuationService.PunctuationByFilmIdUserId(id, principal.getId()));
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
        List<GenreEntity> listGenres = genreService.listGenres();
        model.addAttribute("film", filmDTO);
        model.addAttribute("listGenres", listGenres);
//        model.addAttribute("rating",punctuationDTO);

        return "film/edit";
    }

    @Transactional
    @PostMapping(value = {"/film/{id}/edit", "/film/create"})
    public String save(FilmDTO dto) {
        return String.format("redirect:/film/filmInfo/%s", this.filmService.save(dto).getId());
    }

    @PostMapping(value = {"/film/{id}/delete"})
    public String delete(@PathVariable(value = "id") Integer id) {
        FilmDTO filmDTO = this.filmService.findById(id).get();
        FilmEntity filmEntity= filmService.getServiceMapper().toEntity(filmDTO);
        filmService.getRepository().delete(filmEntity);
        return "redirect:/film";

    }

    @GetMapping("/recomendador")
    public String listRec(Model model) {

        List<GenreEntity> listGenres = genreService.listGenres();
        model
                .addAttribute("listGenres", listGenres)
                .addAttribute("noCargues", true);
        return "recomendador";


    }

    @PostMapping("/recomendador")
    public String listRec(Model model, @Param("keygenre") String keygenre, @Param("minvalue") String minvalue, @Param("maxvalue") String maxvalue,
                          @Param("minyear") String minyear, @Param("maxyear") String maxyear, @Param("platformid") String platformid, @Param("rate") String rate) {

        List<GenreEntity> listGenres = genreService.listGenres();
        try {
            List<FilmDTO> all = this.filmService.recomList(keygenre, minvalue, maxvalue, minyear, maxyear, platformid, rate);
            model
                    .addAttribute("listGenres", listGenres)
                    .addAttribute("films", all)
                    .addAttribute("keygenre", keygenre)
                    .addAttribute("minvalue", minvalue)
                    .addAttribute("maxvalue", maxvalue)
                    .addAttribute("minyear", minyear)
                    .addAttribute("maxyear", maxyear)
                    .addAttribute("platformid", platformid)
                    .addAttribute("rate", rate)
                    .addAttribute("boton2", true);
        }catch(Exception e){
            model
                    .addAttribute("listGenres", listGenres)
                    .addAttribute("error",true);
        }
        return "recomendador";
    }

    @GetMapping("/film/filmInfo/{id}")
    public String viewInfo(@PathVariable("id") Integer id, ModelMap model) {
        Integer userId ;
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            userId=3;
        }else userId=((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        UserEntity user = userRepository.findById(userId).get();
        CommentDTO commentDTO=new CommentDTO();
        FilmDTO filmDTO = filmService.findById(id).get();
        FilmEntity film= filmService.getServiceMapper().toEntity(filmDTO);
        List<CommentDTO> listComments= commentService.findByFilmId(id);
        List<UrlDTO> urls = urlService.findByFilmId(id);
        model
                .addAttribute("film", film)
                .addAttribute("listComments",listComments)
                .addAttribute("user",user)
                .addAttribute("comment", commentDTO)
                .addAttribute("urls", urls);
               

        return "film/filmInfo";
    }

    @PostMapping({ "/comment/delete/{id}/{idFilm}" })
    public Object delete(@PathVariable(value = "id") Integer id,@PathVariable(value = "idFilm") Integer idFilm,
                         SessionStatus status) {
        try {
            this.commentService.delete(id);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", id)
                    .addObject("entityName", "task")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/film/filmInfo/{idFilm}");
        }
        status.setComplete();
        return "redirect:/film/filmInfo/{idFilm}";
    }

    @PostMapping({ "/favourite/agree/{id}" })
    public Object favourite(@PathVariable(value = "id") Integer id) {
        Integer userId ;
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            userId=3;
        }else userId=((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        UserEntity user = userRepository.findById(userId).get();
        user.addFavourite(filmMapper.toEntity(filmService.findById(id).get()));
        userRepository.save(user);


        return "redirect:/film/filmInfo/{id}?successful";
    }

    @PostMapping({ "/favourite/remove/{id}" })
    public Object quitFavourite(@PathVariable(value = "id") Integer id) {
        Integer userId ;
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            userId=3;
        }else userId=((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        UserEntity user = userRepository.findById(userId).get();
        userRepository.deleteFavourite(id,user.getId());

        return "redirect:/film/filmInfo/{id}?remove";
    }

    @PostMapping("/filmInfo/save/{id}")
    public String saveComment(CommentDTO commentDTO,@PathVariable("id") Integer id) {

        commentService.save(commentDTO);

        return "redirect:/film/filmInfo/{id}";
    }

}
