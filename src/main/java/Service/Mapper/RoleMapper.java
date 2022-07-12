package Service.Mapper;

import com.example.KeVeo.data.entity.RoleEntity;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;

@Service
public class RoleMapper extends AbstractServiceMapper<RoleEntity, RoleDTO> {

    public RoleEntity toEntity(RoleDTO dto) {
        final RoleEntity entity = new RoleEntity();
        entity.setId(dto.getId());
        entity.setRoleName(dto.getRoleName());
        return entity;
    }

    public RoleDTO toDto(Role entity) {
        final RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setRoleName(entity.getRoleName());
        return dto;
    }
}
