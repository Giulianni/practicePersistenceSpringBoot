package com.practice.persistencepractice.persistence.model.login;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
    private String password;

    @Transient
    private String[] roles;

//    @OneToMany @JoinTable(name = "roles",
//            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false))
    @ManyToMany
    @JoinTable(name="user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private List<Role> rolesUser;
   // private List<Integer> roleIds;
//    @Transient
//    private String[] roles;


}
