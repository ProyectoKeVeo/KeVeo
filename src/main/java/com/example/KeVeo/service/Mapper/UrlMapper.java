package com.example.KeVeo.service.Mapper;

import com.example.KeVeo.DTO.UrlDTO;
import com.example.KeVeo.data.entity.UrlEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UrlMapper extends AbstractServiceMapper<UrlEntity, UrlDTO> {

    private ModelMapper modelMapper = new ModelMapper();

    public UrlDTO toDto(UrlEntity urlEntity) {

        return modelMapper.map(urlEntity, UrlDTO.class);

    }
    public UrlEntity toEntity(UrlDTO urlDTO) {

        return modelMapper.map(urlDTO, UrlEntity.class);

    }

}
