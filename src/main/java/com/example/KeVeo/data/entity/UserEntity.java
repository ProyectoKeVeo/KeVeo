package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

    @Column(name = "login", nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "USER_NAME", nullable = false)
    private String accountName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean active;

    private Date date;

    public UserEntity(String username, String password, String accountName, String email, boolean active, Date date, List<RoleEntity> roleEntitiesUser) {
        this.username = username;
        this.password = password;
        this.accountName = accountName;
        this.email = email;
        this.active = active;
        this.date = date;
        this.roleEntitiesUser = roleEntitiesUser;
    }

    //Añado relación hacia PuntuationEntity
    @OneToMany (mappedBy = "userEntityPuntuation")
    private Set<PunctuationEntity> puntuationEntitiesUsers = new HashSet<>();

    //Añado relación hacia RoleEntity
    @ManyToMany(mappedBy = "userEntitiesRole", fetch = FetchType.EAGER)
    private List<RoleEntity> roleEntitiesUser;

    //Añado relación hacia NotificationEntity
    @ManyToMany(mappedBy = "userEntitiesNotification")
    private Set<NotificationEntity> notificationEntitiesUser;
}
