package com.example.KeVeo.data.repository;

import com.example.KeVeo.data.entity.FilmEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
    @Query("SELECT distinct f FROM FilmEntity f " +
            "JOIN f.genres g " +
            "JOIN f.url u  " +
            "JOIN u.platform p  " +
            "WHERE CONCAT(f.name, g.title, f.cast, p.name) " +
            "LIKE %?1% ")
    Page<FilmEntity>findAll(String keyWord, Pageable pageable);
    Optional<FilmEntity> findById(Integer id);
    FilmEntity findByName(String name);

    @Query("SELECT f FROM FilmEntity f " +
            "JOIN f.genres g " +
            "JOIN f.url u  " +
            "JOIN u.platform p  " +
            "JOIN f.punctuation pu " +
            "WHERE g.title LIKE %?1% " +
            "AND f.duration BETWEEN ?2 AND ?3 " +
            "AND f.year BETWEEN ?4 AND ?5 " +
            "AND p.id = ?6 " +
            "AND pu.stars >= ?7 "
    )
    List<FilmEntity> findByFilters (String keygenre, Integer minvalue, Integer maxvalue, Integer minyear, Integer maxyear, Integer platformid, Float rate);

}
