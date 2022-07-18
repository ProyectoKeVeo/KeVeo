package com.example.KeVeo.data.entity;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;


@Entity
@Table(name = "bill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private ZonedDateTime date;

    // Añadimos relación @OneToOne hacia PlatformEntity.
    @OneToOne
    @JoinColumn(name = "platform_id", referencedColumnName = "id", unique = true)
    private PlatformEntity platformEntity;

    // Añado getter y setter

}
