package com.example.KeVeo.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "punctuation")
public class PunctuationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String opinion;

    // Añadimos relaciones con FilmEntity y UserEntity
    @ManyToOne
    private FilmEntity filmEntityPuntuation;
    @ManyToOne
    private UserEntity userEntityPuntuation;

    //Añado getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

}
