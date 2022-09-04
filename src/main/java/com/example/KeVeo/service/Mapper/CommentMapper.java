package com.example.KeVeo.service.Mapper;

import com.example.KeVeo.DTO.CommentDTO;
import com.example.KeVeo.data.entity.CommentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper extends AbstractServiceMapper<CommentEntity, CommentDTO>{

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public CommentEntity toEntity(CommentDTO commentDTO) {
        return modelMapper.map(commentDTO, CommentEntity.class);
    }

    @Override
    public CommentDTO toDto(CommentEntity comment) {
        return modelMapper.map(comment, CommentDTO.class);
    }
}
