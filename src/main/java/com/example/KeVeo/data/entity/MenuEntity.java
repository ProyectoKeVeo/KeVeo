package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "menus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer active;

    @Column(nullable = false)
    private String description;
    @Column(name = "APP_ORDER")
    private Integer app_order;
    private String url;
    @ManyToOne
    private MenuEntity parent;

    // Añado relación con RoleEntity
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "menus_roles",
            joinColumns = @JoinColumn(name= "menus_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<RoleEntity> roles;


}