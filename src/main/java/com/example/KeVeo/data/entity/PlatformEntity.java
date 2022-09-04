package com.example.KeVeo.data.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "platform")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlatformEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double commission;

    // Añado relación de Platform hacia BillENtity. Una relación de Uno a uno.
    @OneToOne(mappedBy = "platform", cascade = CascadeType.ALL)
    private BillEntity bill;

    // Añadimos relación @OneToMany de platformEntity hacia ClicksEntity
    @OneToMany (mappedBy = "platform")
    private Set<ClicksEntity> clicks;

    // Añadimos relación entre PlatformEntity con Url
    @OneToMany (mappedBy = "platform")
    private Set<UrlEntity> url;

}
