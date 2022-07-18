package com.example.KeVeo.service.Mapper;

import com.example.KeVeo.DTO.MenuDTO;
import com.example.KeVeo.data.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MenuMapper extends AbstractServiceMapper<MenuEntity, MenuDTO> {
    private final RoleMapper roleMapper;
    @Autowired
    public MenuMapper(RoleMapper roleMapper){this.roleMapper = roleMapper;}
    public MenuEntity toEntity(MenuDTO dto){
        final MenuEntity entity = new MenuEntity();
        entity.setId(dto.getId());
        entity.setActive(dto.getActive());
        entity.setDescription(dto.getDescription());
        entity.setApp_order(dto.getApp_order());
        entity.setUrl(dto.getUrl());
        entity.setParent(toEntity(dto.getParent()));
        entity.setRoleEntities(this.roleMapper.toEntity(dto.getRoles().stream().collect(Collectors.toList())).stream().collect(Collectors.toSet())
        );

        entity.setApp_order(dto.getApp_order());
        entity.setParent(toEntity(dto.getParent()));

        entity.setRoleEntities(this.roleMapper.toEntity(dto.getRoles().stream().collect(Collectors.toList())).stream()
                .collect(Collectors.toSet()));
        return entity;

    }
    public MenuDTO toDto(MenuEntity entity) {
        final MenuDTO dto = new MenuDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());
        dto.setApp_order(entity.getApp_order());
        dto.setParent(entity.getParent() != null ? toDto(entity.getParent()) : null);
        dto.setUrl(entity.getUrl());
        dto.setRoles(this.roleMapper.toDto(entity.getRoleEntities().stream().collect(Collectors.toList())).stream()
                .collect(Collectors.toSet()));
        return dto;
    }

}
