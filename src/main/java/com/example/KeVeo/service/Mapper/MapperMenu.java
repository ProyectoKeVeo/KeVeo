package com.example.KeVeo.service.Mapper;


import com.example.KeVeo.data.entity.MenuEntity;
import com.example.KeVeo.DTO.MenuDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperMenu extends AbstractServiceMapper<MenuEntity, MenuDTO> {

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public MenuEntity toEntity(MenuDTO menuDTO) {
        return modelMapper.map(menuDTO, MenuEntity.class);
    }

    @Override
    public MenuDTO toDto(MenuEntity menu) {
        return modelMapper.map(menu, MenuDTO.class);
    }
}
