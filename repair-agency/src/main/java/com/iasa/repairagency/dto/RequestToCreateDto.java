package com.iasa.repairagency.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class RequestToCreateDto {

    private String description;

    private String managerName;

    private Long clientId;

}
