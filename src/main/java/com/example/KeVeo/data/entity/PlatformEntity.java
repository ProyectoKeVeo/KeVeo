package com.example.KeVeo.data.entity;

import javax.persistence.*;

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

    // TODO: 05/07/2022 foreign keys

}
