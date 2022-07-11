package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;


    // Añado relación de genre a FilmEntity
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "genre_has_film",
            joinColumns = @JoinColumn(name= "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    private Set<FilmEntity> filmEntitiesGenre;
}
