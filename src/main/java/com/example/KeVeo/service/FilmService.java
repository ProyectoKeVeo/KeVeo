package com.example.KeVeo.service;

import com.example.KeVeo.DTO.FilmDTO;
import com.example.KeVeo.data.entity.FilmEntity;
import com.example.KeVeo.data.entity.GenreEntity;
import com.example.KeVeo.data.entity.PunctuationEntity;
import com.example.KeVeo.data.repository.FilmRepository;
import com.example.KeVeo.data.repository.GenreRepository;
import com.example.KeVeo.data.repository.PunctuationRepository;
import com.example.KeVeo.service.Mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService extends AbstractBusinessService<FilmEntity, Integer, FilmDTO, FilmRepository, FilmMapper> {

    @Autowired
    private GenreRepository genreRepository;
    private PunctuationRepository punctuationRepository;


    @Autowired
    protected FilmService(FilmRepository repository, FilmMapper serviceMapper, GenreRepository genreRepository, PunctuationRepository punctuationRepository) {
        super(repository, serviceMapper);
        this.genreRepository = genreRepository;
        this.punctuationRepository= punctuationRepository;
    }
    public Page<FilmDTO> findAll(Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }
    public List<GenreEntity> listGenres() {
        return genreRepository.findAll();
    }


//    public FilmDTO findByFilmName(String filmName) {
//        FilmEntity filmEntity = this.getRepository().findByName(filmName);
//        return this.getServiceMapper().toDto(filmEntity);
//
//    }

}
