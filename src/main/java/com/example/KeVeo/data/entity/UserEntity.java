package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(name = "USER_NAME", nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean active;

    private Date date;


    //Añado relación hacia PuntuationEntity
    @OneToMany (mappedBy = "userEntityPuntuation")
    private Set<PunctuationEntity> puntuationEntitiesUsers = new HashSet<>();

    //Añado relación hacia RoleEntity
    @ManyToMany(mappedBy = "userEntitiesRole")
    private Set<RoleEntity> roleEntitiesUser;

    //Añado relación hacia NotificationEntity
    @ManyToMany(mappedBy = "userEntitiesNotification")
    private Set<NotificationEntity> notificationEntitiesUser;
}
