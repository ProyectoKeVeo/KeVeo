package com.example.KeVeo.service;

import com.example.KeVeo.DTO.PunctuationDTO;
import com.example.KeVeo.data.entity.PunctuationEntity;
import com.example.KeVeo.data.repository.FilmRepository;
import com.example.KeVeo.data.repository.PunctuationRepository;
import com.example.KeVeo.data.repository.UserRepository;
import com.example.KeVeo.service.Mapper.PunctuationMapper;
import org.springframework.stereotype.Service;

@Service
public class PunctuationService extends AbstractBusinessService<PunctuationEntity, Integer, PunctuationDTO, PunctuationRepository, PunctuationMapper> {

    private UserRepository userRepository;
    private FilmRepository filmRepository;

    protected PunctuationService(PunctuationRepository repository, PunctuationMapper serviceMapper, UserRepository userRepository, FilmRepository filmRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
    }

    public void saveStars(PunctuationDTO punctuationDTO) {
        PunctuationEntity punctuationEntity = getServiceMapper().toEntity(punctuationDTO);
        getRepository().save(punctuationEntity);
    }


}
