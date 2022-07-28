package com.example.KeVeo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO implements Serializable {

    private Integer id;

    private Integer active;

    private String description;

    private Integer app_order;

    private String url;

    private MenuDTO parent;

    private Set<RoleDTO> roles;

}
