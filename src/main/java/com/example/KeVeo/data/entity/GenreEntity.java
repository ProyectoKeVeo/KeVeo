package com.example.KeVeo.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class GenreEntity {

    @Id
    @Column(name = "id_genre")
    private Integer id;

    private String title;


    //*********************************GETTERS & SETTERS****************************************************************


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

    //**************************************CONSTRUCTORS****************************************************************


    public GenreEntity() {

    }

    public GenreEntity(Integer id) {
        this.id = id;
    }

    public GenreEntity(String title) {
        this.title = title;
    }

    // Añado relación de genre a FilmEntity

    @ManyToMany(mappedBy = "filmEntities")
    private List<FilmEntity> filmEntities;
}