package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Lob
    private String content;

    private LocalDateTime creation;

    @ManyToOne(fetch = FetchType.LAZY)
    private FilmEntity film;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
