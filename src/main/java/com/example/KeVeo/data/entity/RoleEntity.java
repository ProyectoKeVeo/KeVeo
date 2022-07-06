package com.example.KeVeo.data.entity;


import javax.persistence.*;

@Entity
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRole")
    private Integer id;

    @Column(name = "roleName")
    private String roleName;

}
