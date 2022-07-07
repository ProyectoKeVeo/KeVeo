package com.example.KeVeo.data.entity;

import javax.persistence.*;

@Entity
public class MenuEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer id;
    private String active;
    private String description;
    private Integer app_order;
    private String url;
    private Integer parent;



    //*********************************GETTERS & SETTERS****************************************************************

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

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }
}