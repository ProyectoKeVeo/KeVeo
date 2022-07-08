package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.Set;

public class GenreEntity {
    @Id
    @Column(name = "id_genre")
    private Integer id;

    private String title;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





    public GenreEntity(Integer id) {
        this.id = id;
    }

    public GenreEntity(String title) {
        this.title = title;
    }

    // Añado relación de genre a FilmEntity

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "genre_has_film",
            joinColumns = @JoinColumn(name= "film_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false))
    Set<FilmEntity> filmEntitiesGenre;
}
