package com.example.KeVeo.data.repository;

import com.example.KeVeo.data.entity.PunctuationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PunctuationRepository extends JpaRepository<PunctuationEntity, Integer> {
    @Query(value = "SELECT * FROM Punctuation u WHERE u.users_id = :usersId and u.films_id = :filmsId",
            nativeQuery = true)
    PunctuationEntity findByUserAndFilmId(
            @Param("usersId") Integer usersId, @Param("filmsId") Integer filmsId);
}
