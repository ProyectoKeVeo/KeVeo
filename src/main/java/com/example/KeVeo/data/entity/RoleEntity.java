package com.example.KeVeo.data.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ROLE_NAME", nullable = false)
    private String name;


    // Añado relación hacia UserEntity
    @ManyToMany (mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserEntity> users;

    // Añado relación con MenuEntity
    @ManyToMany(mappedBy = "roleEntities")
    private Set<MenuEntity> menuEntities;
}

