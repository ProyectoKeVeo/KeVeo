package com.example.KeVeo.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import java.util.stream.Collectors;

import com.example.KeVeo.data.entity.RoleEntity;
import com.example.KeVeo.data.entity.UserEntity;
import com.example.KeVeo.data.repository.RoleRepository;
import com.example.KeVeo.data.repository.UserRepository;
import com.example.KeVeo.dto.UserDTO;
import com.example.KeVeo.utils.DateUtil;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;

    }


    public void guardarRolDefecto(UserDTO userDTO) throws ParseException {

        RoleEntity roleUser = roleRepository.findByName(userDTO.getRoleName());
        List<RoleEntity> roleEntities = new ArrayList<>();
        roleEntities.add(roleUser);

        UserEntity usuario = new UserEntity(userDTO.getUsername(),
                passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getAccountName(),
                userDTO.getEmail(),
                userDTO.isActive(), DateUtil.stringToDatedate(userDTO.getDate()), userDTO.getregisterDate(),
                roleEntities);


        UserEntity user = new UserEntity();
        user.addRole(roleUser);

        userRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity usuario = userRepository.findByUsername(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getUsername(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }


    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<RoleEntity> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }



    public List<UserEntity> listarUsuarios() {
        return userRepository.findAll();
    }
}
