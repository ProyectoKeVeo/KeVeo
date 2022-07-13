package com.example.KeVeo.service;

import com.example.KeVeo.data.entity.UserEntity;
import com.example.KeVeo.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public abstract class AbstractUserService implements UserDetailsService {
    abstract UserEntity guardar(UserDTO userDTO);

    abstract List<UserEntity> listarUsuarios();
}
