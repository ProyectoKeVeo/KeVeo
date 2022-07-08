package com.example.KeVeo.data.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
public class ClicksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private byte paso;

    @Column(nullable = false)
    private Date date;


    // Añado @ManyToOne dirigida hacia PlatformEntity.
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PlatformEntity platformEntity;
    // Añadimos relación de ClicksEntity hacia PlatformEntity de @ManyToOne
    @ManyToOne
    private PlatformEntity platformEntities;


}
