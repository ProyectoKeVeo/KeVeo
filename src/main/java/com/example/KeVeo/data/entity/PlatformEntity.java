package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlatformEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "platformId")
    private Integer id;

    @Column(name = "platformName")
    private String name;

    @Column(name = "platformCommission")
    private Double commission;

    public PlatformEntity() {
    }

    // TODO: 05/07/2022 foreign keys
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
    // Añado relación en la base de datos de bill (factura) a platform (plataforma). Una relación de Uno a uno.
    @OneToOne(mappedBy = "bill", cascade = CascadeType.ALL)
    private BillEntity billEntity;
    // Añado relación en la base de datos de PlatforEntity hacia filmentity. Una relación de Muchos a Muchos.
    @ManyToMany(mappedBy = "filmEntities")
    private List<FilmEntity> filmEntities;

}
