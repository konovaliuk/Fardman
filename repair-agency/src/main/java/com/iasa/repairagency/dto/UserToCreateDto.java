package com.iasa.repairagency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserToCreateDto {

    private String name;

    private String phone;

    private String login;

    private String password;

    private String role;

    private String clientName;


}
