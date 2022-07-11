package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
