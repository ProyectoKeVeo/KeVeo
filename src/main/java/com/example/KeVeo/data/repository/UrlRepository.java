package com.example.KeVeo.data.repository;

import com.example.KeVeo.data.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Integer> {

    @Query("Select u FROM UrlEntity u JOIN u.films f JOIN u.platform p " +
            "WHERE f.id = ?1 AND u.active = 1 ORDER BY p.id ")
    List<UrlEntity> findUrlByFilmId (Integer idFilm);

}
