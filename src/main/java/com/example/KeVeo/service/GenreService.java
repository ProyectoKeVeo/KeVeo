package com.example.KeVeo.service;

import com.example.KeVeo.DTO.GenreDTO;
import com.example.KeVeo.data.entity.GenreEntity;
import com.example.KeVeo.data.repository.FilmRepository;
import com.example.KeVeo.data.repository.GenreRepository;
import com.example.KeVeo.service.Mapper.GenreMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends AbstractBusinessService<GenreEntity, Integer, GenreDTO, GenreRepository, GenreMapper> {

    private FilmRepository filmRepository;


    protected GenreService(GenreRepository repository, GenreMapper serviceMapper, FilmRepository filmRepository) {
        super(repository, serviceMapper);
        this.filmRepository = filmRepository;
    }

    public Page<GenreDTO> findAll (Pageable pageable){
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

}
