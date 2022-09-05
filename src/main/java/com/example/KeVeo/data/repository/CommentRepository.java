package com.example.KeVeo.data.repository;

import com.example.KeVeo.data.entity.CommentEntity;
import com.example.KeVeo.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    List<CommentEntity> findByFilmId(Integer id);

    UserEntity findByUserId(Integer id);

}
