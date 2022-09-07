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
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "notification_users",
            joinColumns = @JoinColumn(name= "notification_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<UserEntity> users;


    //Añado relación con NotificationTypeEntity
    @OneToOne(mappedBy = "notification", cascade = CascadeType.ALL)
    private NotificationTypeEntity notificationtype;

}
