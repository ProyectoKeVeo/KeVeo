/*package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Integer id;

    // @NotBlank Para este mapeo se necesita la libreria validation
    private String title;

    //@NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "genre_film",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_genre"))
    private List<genre> generos;


}*/
