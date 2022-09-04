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
    private String opinion;

    // Añadimos relaciones con FilmEntity y UserEntity
    @ManyToOne
    private FilmEntity films;
    @ManyToOne
    private UserEntity users;
}