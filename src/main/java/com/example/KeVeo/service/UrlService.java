package com.example.KeVeo.service;


import com.example.KeVeo.DTO.UrlDTO;
import com.example.KeVeo.data.entity.UrlEntity;
import com.example.KeVeo.data.repository.UrlRepository;
import com.example.KeVeo.service.Mapper.UrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService extends AbstractBusinessService<UrlEntity, Integer, UrlDTO, UrlRepository, UrlMapper>{

    @Autowired
    protected UrlService(UrlRepository repository, UrlMapper serviceMapper) {
        super(repository, serviceMapper);
    }

    public List<UrlDTO> findByFilmId (Integer idFilm){
        return getServiceMapper().toDto(this.getRepository().findUrlByFilmId(idFilm));
    }
}
