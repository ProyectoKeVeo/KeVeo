package com.example.KeVeo.service;


import com.example.KeVeo.data.entity.MenuEntity;
import com.example.KeVeo.data.entity.RoleEntity;
import com.example.KeVeo.data.entity.UserEntity;
import com.example.KeVeo.data.repository.MenuRepository;
import com.example.KeVeo.data.repository.RoleRepository;
import com.example.KeVeo.data.repository.UserRepository;
import com.example.KeVeo.DTO.MenuDTO;
import com.example.KeVeo.service.Mapper.MapperMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MenuService extends AbstractBusinessService<MenuEntity, Integer, MenuDTO, MenuRepository, MapperMenu> {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    protected MenuService(MenuRepository repository, MapperMenu serviceMapper,
                          UserRepository userRepository, RoleRepository roleRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<MenuDTO> getMenuForUserId(Integer userId) {
        UserEntity user = this.userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(String.format("The user ID %s does not exist", userId)));
        return getMenuForRole(user.getRoles());
    }

    public List<MenuDTO> getMenuForRole(Collection<RoleEntity> roles) {
        List<MenuEntity> menus = this.getRepository().findDistinctByRolesIn(roles);
        return this.getServiceMapper().toDto(menus);
    }
}
