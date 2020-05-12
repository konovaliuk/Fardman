package com.iasa.repairagency.dto;

import lombok.Data;

@Data
public class  FeedbackToLeaveDto {

    private String text;
    private Long requestId;
    private Long clientId;
}
