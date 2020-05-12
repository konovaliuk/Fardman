package com.iasa.repairagency.dto;

import lombok.Data;

@Data
public class RequestToAcceptDto {

    private Long requestId;
    private String masterName;
    private Integer cost;
}
