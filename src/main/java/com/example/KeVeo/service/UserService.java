package com.example.KeVeo.service;

import java.util.Arrays;
import java.util.Collection;

import java.util.List;
import java.util.stream.Collectors;

import com.example.KeVeo.data.entity.RoleEntity;
import com.example.KeVeo.data.entity.UserEntity;
import com.example.KeVeo.data.repository.UserRepository;
import com.example.KeVeo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService extends AbstractUserService {


    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity guardar(UserDTO userDTO) {
        UserEntity usuario = new UserEntity(userDTO.getUsername(),
                passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getAccountName(),
                userDTO.getEmail(),
                userDTO.isActive(), userDTO.getDate(),
                Arrays.asList(new RoleEntity("ROLE_USER")));
        return userRepository.save(usuario);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity usuario = userRepository.findByUsername(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getUsername(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoleEntitiesUser()));
    }


    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<RoleEntity> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }


    @Override
    public List<UserEntity> listarUsuarios() {
        return userRepository.findAll();
    }
}
