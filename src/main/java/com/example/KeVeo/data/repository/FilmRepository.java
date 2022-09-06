package com.example.KeVeo.data.repository;

import com.example.KeVeo.data.entity.FilmEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
    @Query("SELECT distinct f FROM FilmEntity f " +
            "JOIN f.genres g " +
            "JOIN f.url u  " +
            "JOIN u.platform p  " +
            "WHERE CONCAT(f.name, g.title, f.cast, p.name) " +
            "LIKE %?1% ORDER BY f.id ")
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

    @Transactional
    @Query(value="SELECT f.* FROM films AS f INNER JOIN users_films AS uf ON f.id = uf.films_id INNER JOIN users AS u ON uf.users_id = u.id WHERE u.id LIKE %?1%", nativeQuery = true)
    Page<FilmEntity> findAllFavourite(Pageable pageable,Integer id);

    @Query("SELECT f FROM FilmEntity f ORDER BY f.year DESC")
    List<FilmEntity> findByYear();
    @Query("SELECT f FROM FilmEntity f ORDER BY f.id DESC")
    List<FilmEntity> findByIdDesc();
}
