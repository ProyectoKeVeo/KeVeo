package com.example.KeVeo.data.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRole")
    private Integer id;

    @Column(name = "roleName")
    private String roleName;
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
    // Añado relación hacia user muchos a muchos (@manyToMany)
    @JoinTable(
            name = "url",
            joinColumns = @JoinColumn(name= "ROLES_ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "USERS_ID", nullable = false)
    )

    @ManyToMany (cascade = CascadeType.ALL)
    private List<RoleEntity> roleEntities;
}

