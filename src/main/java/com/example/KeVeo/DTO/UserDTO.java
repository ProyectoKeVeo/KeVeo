package com.example.KeVeo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.ZonedDateTime;



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
    private String username2;

    private String date;

    private ZonedDateTime registerDate;

    private String roleName;

    public ZonedDateTime getregisterDate(){
        ZonedDateTime fecha = ZonedDateTime.now();
        return fecha;
    }

}
