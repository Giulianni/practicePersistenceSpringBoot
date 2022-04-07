package com.practice.persistencepractice.persistence.model;

import com.practice.persistencepractice.persistence.model.login.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;

    private Integer menuFatherId;

    private String menuName;


    @ManyToMany
    @JoinTable(name="menu_roles", joinColumns = @JoinColumn(name = "menu_menuId"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private List<Role> roles;




}
