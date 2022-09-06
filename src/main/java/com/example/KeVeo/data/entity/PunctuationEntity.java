package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "punctuation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PunctuationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private Float stars;

    // Añadimos relaciones con FilmEntity y UserEntity
    @ManyToOne
    @JoinColumn(name = "films_id")
    private FilmEntity films;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity users;
}
