package com.example.KeVeo.data.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "url")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private String url;

    // Añadimos relación de UrlEntity hacia PlatformEntity
    @ManyToOne
    @JoinColumn(name = "platform_id")
    private PlatformEntity platform;

    @ManyToOne
    @JoinColumn(name = "films_id")
    private FilmEntity films;
}
