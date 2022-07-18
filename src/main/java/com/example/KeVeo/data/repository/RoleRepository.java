package com.example.KeVeo.data.repository;

import com.example.KeVeo.data.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {


    public RoleEntity findByName (String name);

}
