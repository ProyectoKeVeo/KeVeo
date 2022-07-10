package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film")
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
    @ManyToMany (mappedBy = "filmEntitiesGenre")
    private Set<GenreEntity> genreEntities;

    // Añado los getter y los setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getNumber_views() {
        return number_views;
    }

    public void setNumber_views(Integer number_views) {
        this.number_views = number_views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public ZonedDateTime getCreation() {
        return creation;
    }

    public void setCreation(ZonedDateTime creation) {
        this.creation = creation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}






