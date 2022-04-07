package com.practice.persistencepractice.persistence.model.login;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practice.persistencepractice.persistence.model.Menu;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter @Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roleName;
    private String roleDescription;

    //@JsonIgnore
    @ManyToMany(mappedBy = "rolesUser")
    private List<User> user; //revisar esto. Creo que esta info no tiene que estar acá. O capaz por lo menos la relacion no deberia.

    @ManyToMany(mappedBy = "roles")
    private List<Menu> menus;

    public Role(){

    }

    public Role(Integer id) {
        this.id = id;
    }

    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
}

//falta mapear users y roles