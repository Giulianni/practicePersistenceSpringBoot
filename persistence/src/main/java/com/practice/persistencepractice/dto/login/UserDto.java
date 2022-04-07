package com.practice.persistencepractice.dto.login;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserDto {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
    private String password;
    private List<Integer> roleIds;

}
