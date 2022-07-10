package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
