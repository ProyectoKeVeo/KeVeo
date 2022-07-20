package com.example.KeVeo.service.Mapper;


import com.example.KeVeo.DTO.RoleDTO;
import com.example.KeVeo.data.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperRol extends AbstractServiceMapper<RoleEntity, RoleDTO> {

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public RoleDTO toDto(RoleEntity role) {

        return modelMapper.map(role, RoleDTO.class);
    }

    @Override
    public RoleEntity toEntity(RoleDTO roleDTO) {

        return modelMapper.map(roleDTO, RoleEntity.class);

    }
}
