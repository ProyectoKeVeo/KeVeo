package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NotificationTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificationTypeId")
    private Integer id;

    @Column(name = "notificationTypeType")
    private String type;

// TODO: 05/07/2022 foreign keys y enum 
}
