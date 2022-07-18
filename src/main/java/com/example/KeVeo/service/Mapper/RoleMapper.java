package com.example.KeVeo.service.Mapper;

import com.example.KeVeo.DTO.RoleDTO;
import com.example.KeVeo.data.entity.RoleEntity;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;

@Service
public class RoleMapper extends AbstractServiceMapper<RoleEntity, RoleDTO> {

    public RoleEntity toEntity(RoleDTO dto) {
        final RoleEntity entity = new RoleEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getRoleName());
        return entity;
    }

    public RoleDTO toDto(RoleEntity entity) {
        final RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setRoleName(entity.getName());
        return dto;
    }
}
