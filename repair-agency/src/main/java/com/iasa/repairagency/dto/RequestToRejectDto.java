package com.iasa.repairagency.dto;

import lombok.Data;

@Data
public class RequestToRejectDto {

    private Long requestId;
    private String reason;
}
