package com.example.KeVeo.service;

import com.example.KeVeo.data.entity.UserEntity;
import com.example.KeVeo.data.repository.UserRepository;
import com.example.KeVeo.DTO.UserDTO;
import com.example.KeVeo.service.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GestionUserService extends AbstractBusinessService<UserEntity,Integer,UserDTO, UserRepository, UserMapper> {

    @Autowired
    protected GestionUserService(UserRepository repository, UserMapper serviceMapper) {
        super(repository, serviceMapper);
    }

    @Override
    public UserDTO save(UserDTO dto) {
        final UserEntity entity = getServiceMapper().toEntity(dto);
        final UserEntity savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }

    public Page<UserDTO> findAll(Integer userId, Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }
}
