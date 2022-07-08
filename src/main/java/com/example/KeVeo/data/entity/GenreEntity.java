package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.Set;

public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
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


    // Añado relación de genre a FilmEntity

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "genre_has_film",
            joinColumns = @JoinColumn(name= "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    Set<FilmEntity> filmEntitiesGenre;
}
