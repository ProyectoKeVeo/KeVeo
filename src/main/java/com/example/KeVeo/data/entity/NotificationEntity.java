package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "notification")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private ZonedDateTime date;

    // Añado relación hacia UserEntity
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "notification_has_user",
            joinColumns = @JoinColumn(name= "notification_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserEntity> userEntitiesNotification;


    //Añado relación con NotificationTypeEntity
    @OneToOne(mappedBy = "notificationEntity", cascade = CascadeType.ALL)
    private NotificationTypeEntity notificationTypeEntity;


    // añadidos getter y setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }


}
