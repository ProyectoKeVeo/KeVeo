package Service.Mapper;
import com.example.KeVeo.data.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapper  extends AbstractServiceMapper<UserEntity, UserDTO> {
    public UserMapper(RoleMapper roleMapper) {this.roleMapper = roleMapper;}
    }
    @Override
public UserEntity toEntity(UserDTO userDTO){
     UserEntity = new UserEntity();
        entity().setId(userDTO.getId());
        entity().setUsername(userDTO.getUserName());
        entity().setLogin(userDTO.getLogin());
        entity().setPassword(userDTO.getPassword());
        entity().setEmail(userDTO.getEmail());
        entity().setActive(userDTO.getActive());
        entity().setDate(userDTO.getDate());
        return entity;
    }
    public UserDTO toDto(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUserName(entity.getUsername());
        dto.setLogin(entity.getLogin());
        // En este caso, no ponemosdto.setPassword() ya que esta no se edita ni se lista.
        dto.setEmail(entity.getEmail());
        dto.setActive(entity.isActive());
        dto.setDate(entity.getDate());
        return dto;
    }
}
