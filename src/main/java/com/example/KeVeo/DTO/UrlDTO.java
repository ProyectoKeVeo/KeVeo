package com.example.KeVeo.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class UrlDTO implements Serializable {
    private Integer id;
    private Boolean active;
    private String url;
    private Integer platformId;
    private Integer filmsId;

}
