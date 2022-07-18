package com.example.KeVeo.service.Mapper;
import com.example.KeVeo.DTO.UserDTO;
import com.example.KeVeo.data.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapper  extends AbstractServiceMapper<UserEntity, UserDTO> {
    private final RoleMapper roleMapper;
    public UserMapper(RoleMapper roleMapper) {this.roleMapper = roleMapper;}

    @Override
public UserEntity toEntity(UserDTO userDTO){
     UserEntity entity = new UserEntity();
        entity.setId(userDTO.getId());
        entity.setUsername(userDTO.getUsername());
        entity.setPassword(userDTO.getPassword());
        entity.setEmail(userDTO.getEmail());
        entity.setActive(userDTO.isActive());
        return entity;
    }
    public UserDTO toDto(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        // En este caso, no ponemosdto.setPassword() ya que esta no se edita ni se lista.
        dto.setEmail(entity.getEmail());
        dto.setActive(entity.isActive());
        return dto;
    }
}
