package com.example.KeVeo.service.Mapper;


import com.example.KeVeo.DTO.UserDTO;
import com.example.KeVeo.data.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class MapperUser extends AbstractServiceMapper<UserEntity, UserDTO> {
    private ModelMapper modelMapper = new ModelMapper();
    public UserDTO toDto(UserEntity user) {

        return modelMapper.map(user, UserDTO.class);

    }
    public UserEntity toEntity(UserDTO userDTO) {

        return modelMapper.map(userDTO, UserEntity.class);

    }

}


