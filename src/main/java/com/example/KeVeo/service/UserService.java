package com.example.KeVeo.service;
import com.example.KeVeo.DTO.UserDTO;
import com.example.KeVeo.data.entity.RoleEntity;
import com.example.KeVeo.data.entity.UserEntity;
import com.example.KeVeo.data.repository.RoleRepository;
import com.example.KeVeo.data.repository.UserRepository;
import com.example.KeVeo.service.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService extends AbstractBusinessService<UserEntity, Integer, UserDTO, UserRepository, UserMapper> {
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    protected UserService(UserRepository repository, UserMapper serviceMapper, RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder) {
        super(repository, serviceMapper);

        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerDefaultUser(UserDTO userDTO) {
        RoleEntity roleUser = roleRepository.findByName("ROLE_USER");
        UserEntity entity=getServiceMapper().toEntity(userDTO);
        entity.addRole(roleUser);
        encodePassword(entity);
        getRepository().save(entity);
    }

    private void encodePassword(UserEntity user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity usuario = getRepository().findByUsername(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getUsername(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }


    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<RoleEntity> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


    public List<UserEntity> listarUsuarios() {
        return getRepository().findAll();
    }
}
