package com.example.KeVeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String accountName;

    private boolean active;

    private Date date;

    public Date getDate(){
        LocalDate fecha = LocalDate.now();
        return java.sql.Date.valueOf(fecha);
    }

}
