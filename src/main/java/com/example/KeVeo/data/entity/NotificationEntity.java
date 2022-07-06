package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificationId")
    private Integer id;

    @Column(name = "notificationDescription")
    private String description;

    @Column(name = "notificationDate")
    private Date date;


}
