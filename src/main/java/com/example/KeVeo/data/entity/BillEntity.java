package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billId")
    private Integer id;

    @Column(name = "billName")
    private String name;

    @Column(name = "billDate")
    private Date date;

}
