package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "filmName")
    private String name;

    @Column(name = "filmAge")
    private Integer year;

    @Column(name = "filmLength")
    private Integer length;

    @Column(name = "filmViews")
    private Integer number_views;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
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

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }


    //Añado relación con la clase PlatformEntity con una relación de muchos a muchos (@ManyToMany).


    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "url",
            joinColumns = @JoinColumn(name= "platform_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "film_id", nullable = false)
    )
    private List <PlatformEntity> platformEntities;

    // Añado relación hacia User muchos a muchos (@manyToMany)

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "url",
            joinColumns = @JoinColumn(name= "film_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false)
    )
    private List <UserEntity> userEntities;

    // Añadimos relación de FilmEntity con UrlEntity
    @OneToMany (mappedBy = "filmEntityUrl")
    private Set<UrlEntity> urlEntitiesFilms = new HashSet<>();

// Añadimos relación de FilmEntity y GenreEntity
    @ManyToMany (mappedBy = "filmEntitiesGenre")
    private Set<GenreEntity> genreEntities;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "genre_film",
//            joinColumns = @JoinColumn(name = "id_film"),
//            inverseJoinColumns = @JoinColumn(name = "id_genre"))
//    private List<GenreEntity> generos;

}






