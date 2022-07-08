package com.example.KeVeo.data.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
public class ClicksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private byte paso;

    @Column(nullable = false)
    private Date date;


    // Añado @ManyToOne dirigida hacia PlatformEntity.
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PlatformEntity platformEntity;
    // Añadimos relación de ClicksEntity hacia PlatformEntity de @ManyToOne
    @ManyToOne
    private PlatformEntity platformEntities;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte getStep() {
        return step;
    }

    public void setStep(byte step) {
        this.step = step;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
