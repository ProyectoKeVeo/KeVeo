package com.example.KeVeo.data.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clicks")
public class ClicksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Short step;

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

    public Short getStep() {
        return step;
    }

    public void setStep(Short step) {
        this.step = step;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
