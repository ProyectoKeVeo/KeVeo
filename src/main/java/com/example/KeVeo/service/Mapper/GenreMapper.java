package com.example.KeVeo.service.Mapper;


import com.example.KeVeo.DTO.GenreDTO;
import com.example.KeVeo.data.entity.GenreEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class GenreMapper extends AbstractServiceMapper<GenreEntity, GenreDTO> {
    private ModelMapper modelMapper = new ModelMapper();

    public GenreDTO toDto(GenreEntity genre) {

        return modelMapper.map(genre, GenreDTO.class);

    }
    public GenreEntity toEntity(GenreDTO genreDTO) {

        return modelMapper.map(genreDTO, GenreEntity.class);

    }

}


