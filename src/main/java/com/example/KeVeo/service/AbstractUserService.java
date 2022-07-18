package com.example.KeVeo.service;

import com.example.KeVeo.DTO.UserDTO;
import com.example.KeVeo.data.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.text.ParseException;
import java.util.List;


public abstract class AbstractUserService implements UserDetailsService {
    abstract void guardarRolDefecto(UserDTO userDTO) throws ParseException;

    abstract List<UserEntity> listarUsuarios();
}
