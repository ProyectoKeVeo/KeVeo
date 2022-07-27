package com.example.KeVeo.service.Mapper;

import com.example.KeVeo.DTO.FilmDTO;
import com.example.KeVeo.data.entity.FilmEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@Service
public class FilmMapper extends AbstractServiceMapper<FilmEntity, FilmDTO> {
    private ModelMapper modelMapper = new ModelMapper();
    public FilmDTO toDto(FilmEntity filmEntity) {

        return modelMapper.map(filmEntity, FilmDTO.class);

    }
    public FilmEntity toEntity(FilmDTO filmDTO) {

        return modelMapper.map(filmDTO, FilmEntity.class);

    }

}

