package com.example.KeVeo.data.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "menu")
public class MenuEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String active;

    @Column(nullable = false)
    private String description;
    @Column(name = "APP_ORDER")
    private Integer app_order;
    private String url;
    @ManyToOne
    private MenuEntity parent;

    // Añado relación con RoleEntity
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "menu_roles",
            joinColumns = @JoinColumn(name= "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<RoleEntity> roleEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getApp_order() {
        return app_order;
    }

    public void setApp_order(Integer app_order) {
        this.app_order = app_order;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MenuEntity getParent() {
        return parent;
    }

    public void setParent(MenuEntity parent) {
        this.parent = parent;
    }

}