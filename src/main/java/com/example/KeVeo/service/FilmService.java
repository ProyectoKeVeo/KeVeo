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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
    public Page<FilmDTO> findAll(String keyWord, Pageable pageable) {
        if (keyWord != null){
            return getRepository().findAll(keyWord, pageable).map(getServiceMapper()::toDto);
        }
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

//    public FilmDTO findByFilmName(String filmName) {
//        FilmEntity filmEntity = this.getRepository().findByName(filmName);
//        return this.getServiceMapper().toDto(filmEntity);
//
//    }

    public List<FilmDTO> findbyFilters(String keygenre, Integer minvalue, Integer maxvalue, Integer minyear, Integer maxyear, Integer platfromid, Float rate){
        return getServiceMapper().toDto(this.getRepository().findByFilters(keygenre, minvalue, maxvalue, minyear, maxyear, platfromid, rate));
    }

    public List<FilmDTO> recomList(String keygenre, String minvalue, String maxvalue, String minyear, String maxyear, String platformid, String rate){

        Integer intMinvalue = Integer.parseInt(minvalue);
        Integer intMaxvalue = Integer.parseInt(maxvalue);
        Integer intMinyear = Integer.parseInt(minyear);
        Integer intMaxyear = Integer.parseInt(maxyear);
        Integer intPlatformid = Integer.parseInt(platformid);
        Float floatRate = Float.parseFloat(rate);

        List<FilmDTO> list = findbyFilters(keygenre, intMinvalue, intMaxvalue, intMinyear, intMaxyear, intPlatformid, floatRate);
        List<FilmDTO> random = new ArrayList<>();

        Random rand = new Random();

        int n;
        if(list.size() < 4){
            n = 4 - list.size();
        }else{
            n = 0;
        }

        while(n < 4)
        {
            int nAleatorio = rand.nextInt(list.size());
            FilmDTO elementoAzar = list.get(nAleatorio);

            if(!random.contains(elementoAzar))
            {
                random.add(elementoAzar);
                n++;
            }
        }
        return random;
    }

}
