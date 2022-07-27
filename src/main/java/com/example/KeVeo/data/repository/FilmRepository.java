package com.example.KeVeo.data.repository;

import com.example.KeVeo.data.entity.FilmEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
    Page<FilmEntity>findAll(Pageable pageable);
    Optional<FilmEntity> findById(Integer id);
    FilmEntity findByName(String name);


}
