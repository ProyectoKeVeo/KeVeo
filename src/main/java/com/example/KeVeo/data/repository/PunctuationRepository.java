package com.example.KeVeo.data.repository;

import com.example.KeVeo.data.entity.PunctuationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public interface PunctuationRepository extends JpaRepository<PunctuationEntity, Integer> {
    @Query(value = "SELECT * FROM Punctuation u WHERE u.users_id = :usersId and u.films_id = :filmsId",
            nativeQuery = true)
    PunctuationEntity findByUserAndFilmId(
            @Param("usersId") Integer usersId, @Param("filmsId") Integer filmsId);

    @Transactional
    @Modifying
    @Query("UPDATE PunctuationEntity p set p.stars = :stars where p.stars = :stars2")
    PunctuationEntity updateById(@Param("stars") Float stars, @Param("stars2") Float stars2);


}
