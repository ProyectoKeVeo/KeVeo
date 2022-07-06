package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer id;

    @Column(name = "userLogin")
    private String login;

    @Column(name = "userPassword")
    private String password;

    @Column(name = "userName")
    private String name;

    @Column(name = "userSurname")
    private String surname;

    @Column(name = "userAge")
    private Integer age;

    @Column(name = "userEmail")
    private String email;

    @Column(name = "userSex")
    private boolean sex;

    @Column(name = "userActive")
    private boolean active;


}
