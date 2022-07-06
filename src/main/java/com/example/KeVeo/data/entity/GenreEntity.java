package com.example.KeVeo.data.entity;

import javax.persistence.*;

@Entity
public class GenreEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
