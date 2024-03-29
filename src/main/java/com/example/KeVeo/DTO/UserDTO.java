package com.example.KeVeo.DTO;

import com.example.KeVeo.data.entity.FilmEntity;
import com.example.KeVeo.data.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String accountName;

    private String email;

    private boolean active;
    private String username2;

    private String date;

    private ZonedDateTime registerDate;

    private List<RoleEntity> roles;

    private List<FilmEntity> films= new ArrayList<>();
    public ZonedDateTime getregisterDate(){
        ZonedDateTime fecha = ZonedDateTime.now();
        return fecha;
    }

}
