package com.example.KeVeo.data.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clicks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClicksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Short step;

    @Column(nullable = false)
    private Date date;


    // Añado @ManyToOne dirigida hacia PlatformEntity.
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PlatformEntity platformEntity;
    // Añadimos relación de ClicksEntity hacia PlatformEntity de @ManyToOne
    @ManyToOne
    private PlatformEntity platformEntities;


}
