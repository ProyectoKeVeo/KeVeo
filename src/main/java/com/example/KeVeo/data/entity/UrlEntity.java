package com.example.KeVeo.data.entity;
import javax.persistence.*;

@Entity
@Table(name = "url")
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private String url;

    // Añadimos relación de UrlEntity hacia PlatformEntity
    @ManyToOne
    private PlatformEntity platformEntityUrl;
    @ManyToOne
    private FilmEntity filmEntityUrl;


    // Añadimos Getter y setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
