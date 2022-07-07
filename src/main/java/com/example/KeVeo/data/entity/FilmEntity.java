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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getLength() {
        return length;
    }

    public void setLength(Date length) {
        this.length = length;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
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

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }
    //Añado relación con la clase PlatformEntity con una relación de muchos a muchos (@ManyToMany).
    @JoinTable(
            name = "url",
            joinColumns = @JoinColumn(name= "platform_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "film_id", nullable = false)
    )

    @ManyToMany (cascade = CascadeType.ALL)
    private List <PlatformEntity> platformEntities;

    // Añado relación hacia User muchos a muchos (@manyToMany)
    @JoinTable(
            name = "url",
            joinColumns = @JoinColumn(name= "film_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false)
    )

    @ManyToMany (cascade = CascadeType.ALL)
    private List <UserEntity> userEntities;
    }

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



