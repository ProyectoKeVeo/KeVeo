package com.example.KeVeo.data.entity;

import org.springframework.http.converter.json.GsonBuilderUtils;

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
<<<<<<< HEAD
    public BillEntity() {
=======

    public BillEntity(Integer id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
>>>>>>> 80f109999cefd5bcdd171379697825d11dc641b9
    }
}
