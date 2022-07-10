package com.example.KeVeo.data.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
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


    // añado getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}

