package com.example.KeVeo.DTO;
import com.example.KeVeo.data.entity.GenreEntity;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO implements Serializable {
    private Integer id;
    private String name;
    private Integer year;
    private Integer duration;
    private Integer number_views;
    private String description;
    private String trailer;
    private ZonedDateTime creation;
    private String image;
    private Set<GenreDTO> genres;

    public ZonedDateTime getCreation(){
        ZonedDateTime fecha = ZonedDateTime.now();
        return fecha;
    }

}
