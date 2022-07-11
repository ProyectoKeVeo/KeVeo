package com.example.KeVeo.data.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String roleName;


    // Añado relación hacia UserEntity
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name= "roles_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<UserEntity> userEntitiesRole;

    // Añado relación con MenuEntity
    @ManyToMany(mappedBy = "roleEntities")
    private Set<MenuEntity> menuEntities;
}

