package com.example.KeVeo.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "type_notification")
public class NotificationTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String type;

    private String enumerator;

    // Añado relación hacia NotificationEntity
    @OneToOne
    @JoinColumn(name = "notification_id")
    private NotificationEntity notificationEntity;


    //añadidos getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnumerator() {
        return enumerator;
    }

    public void setEnumerator(String enumerator) {
        this.enumerator = enumerator;
    }

}
