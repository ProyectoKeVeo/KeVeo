package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.*;

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

    @Column(nullable = false, columnDefinition = "default true")
    private boolean active;

    @Column(name = "birth_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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
        this.roles = roleEntitiesUser;
    }

    //Añado relación hacia PuntuationEntity
    @OneToMany (mappedBy = "users")
    private Set<PunctuationEntity> punctuation;

    //Añado relación hacia RoleEntity
    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> roles;

    //Añado relación hacia NotificationEntity
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<NotificationEntity> notification;

    public void addRole (RoleEntity role){
        this.roles = new ArrayList<>();
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                '}';
    }
}
