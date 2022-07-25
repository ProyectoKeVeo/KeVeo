package com.example.KeVeo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreDTO implements Serializable {

    private Integer id;

    private String title;

    @Override
    public String toString() {
        return this.title;
    }
}
