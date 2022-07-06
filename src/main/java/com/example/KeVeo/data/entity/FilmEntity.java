package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filmId")
    private Integer id;

    @Column(name = "filmName")
    private String name;

    @Column(name = "filmAge")
    private Integer age;

    @Column(name = "filmLength")
    private Date length;

    @Column(name = "filmViews")
    private Integer views;

    @Column(name = "filmDescrition")
    private String description;

    @Column(name = "filmTrailer")
    private String trailer;

    @Column(name = "filmCreation")
    private Date creation;
//
//    // @NotBlank Para este mapeo se necesita la libreria validation
//    private String title;
//
//    //@NotEmpty
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "genre_film",
//            joinColumns = @JoinColumn(name = "id_film"),
//            inverseJoinColumns = @JoinColumn(name = "id_genre"))
//    private List<GenreEntity> generos;


}
