package com.practice.persistencepractice.dto;

import com.practice.persistencepractice.dto.login.RoleDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MenuDto {
    private Integer menuId;
    private Integer menuFatherId;
    private String menuName;
    private List<?> role;

}
