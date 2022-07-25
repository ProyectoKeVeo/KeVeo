package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "film")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private Integer number_views;

    @Column(nullable = false)
    private String description;

    private String trailer;

    @Column(name= "creation_date", nullable = false)
    private ZonedDateTime creation;

    private String image;

    //Añado la relación con PuntuationEntity
    @OneToMany (mappedBy = "filmEntityPuntuation")
    private Set<PunctuationEntity> puntuationEntitiesFilms = new HashSet<>();


    // Añadimos relación de FilmEntity con UrlEntity
    @OneToMany (mappedBy = "filmEntityUrl")
    private Set<UrlEntity> urlEntitiesFilms = new HashSet<>();

    // Añadimos relación de FilmEntity y GenreEntity
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "genre_has_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<GenreEntity> genres;



}






