package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genres")
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
    @ManyToMany (mappedBy = "genres", fetch = FetchType.EAGER)
    private Set<FilmEntity> films;
    @Override
    public String toString() {
        return this.title;
    }
}
