package com.example.KeVeo.data.entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PlatformEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double commission;

// añado getter y setter

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

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    // Añado relación de Platform hacia BillENtity. Una relación de Uno a uno.
    @OneToOne(mappedBy = "platformEntity", cascade = CascadeType.ALL)
    private BillEntity billEntity;

    // Añadimos relación @OneToMany de platformEntity hacia ClicksEntity
    @OneToMany (mappedBy = "platformEntities")
    private Set<ClicksEntity> clicksEntities = new HashSet<>();

    // Añadimos relación entre PlatformEntity con Url
    @OneToMany (mappedBy = "platformEntityUrl")
    private Set<UrlEntity> urlEntities = new HashSet<>();

//    // Añado relación en la base de datos de PlatforEntity hacia filmentity. Una relación de Muchos a Muchos.
//    @ManyToMany(mappedBy = "filmEntities")
//    private List<FilmEntity> filmEntities;

}
