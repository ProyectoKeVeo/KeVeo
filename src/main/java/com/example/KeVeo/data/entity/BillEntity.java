package com.example.KeVeo.data.entity;
import javax.persistence.*;
import java.time.ZonedDateTime;


@Entity
@Table(name = "bill")
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
    @JoinColumn(name = "platform_id", unique = true)
    private PlatformEntity platformEntity;

    // Añado getter y setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

}
