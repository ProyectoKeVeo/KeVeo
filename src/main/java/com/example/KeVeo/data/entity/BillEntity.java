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
    public BillEntity() {
    }
    // Añado getter y setter
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
