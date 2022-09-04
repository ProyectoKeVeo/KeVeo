package com.example.KeVeo.service.Mapper;

import com.example.KeVeo.DTO.PunctuationDTO;
import com.example.KeVeo.data.entity.PunctuationEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PunctuationMapper extends AbstractServiceMapper<PunctuationEntity, PunctuationDTO> {
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public PunctuationDTO toDto(PunctuationEntity punctuationEntity) {

        return modelMapper.map(punctuationEntity, PunctuationDTO.class);
    }

    @Override
    public PunctuationEntity toEntity(PunctuationDTO punctuationDTO) {

        return modelMapper.map(punctuationDTO, PunctuationEntity.class);

    }
}
