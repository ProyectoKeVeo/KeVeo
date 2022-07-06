package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ClicksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clicksName")
    private Integer id;

    @Column(name = "clicksStep")
    private byte step;

    @Column(name = "clicksDate")
    private Date date;

    // TODO: 05/07/2022 foreign keys


}
