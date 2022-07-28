package com.example.KeVeo.data.repository;

import com.example.KeVeo.data.entity.MenuEntity;
import com.example.KeVeo.data.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

    List<MenuEntity> findDistinctByRolesIn(Collection<RoleEntity> roles);
}
