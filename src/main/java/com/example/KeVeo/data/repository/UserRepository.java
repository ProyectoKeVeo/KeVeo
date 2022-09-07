package com.example.KeVeo.data.repository;

import com.example.KeVeo.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndActiveTrue(String username);
    @Modifying
    @Transactional
    @Query(value="delete from users_films where films_id LIKE %?1% and users_id LIKE %?2%", nativeQuery = true)
    void deleteFavourite(Integer idFilm, Integer idUser);
}
