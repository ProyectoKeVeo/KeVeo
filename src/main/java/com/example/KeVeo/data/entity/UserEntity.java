package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private boolean active;

    @Column(name = "birth_date")
    private Date date;

    @Column(name = "register_date")
    private ZonedDateTime registerDate;

    public UserEntity(String username, String password, String accountName, String email, boolean active, Date date, ZonedDateTime registerDate, List<RoleEntity> roleEntitiesUser) {
        this.username = username;
        this.password = password;
        this.accountName = accountName;
        this.email = email;
        this.active = active;
        this.date = date;
        this.registerDate = registerDate;
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
