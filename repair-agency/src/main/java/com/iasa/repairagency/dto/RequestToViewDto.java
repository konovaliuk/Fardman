package com.iasa.repairagency.dto;

import com.iasa.repairagency.model.Request;
import com.iasa.repairagency.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestToViewDto {

    private String description;

    private Integer cost;

    private String reason;

    private Boolean accepted;

    private Boolean completed;

    private String clientName;

    private String clientPhone;

    private String masterName;

    public RequestToViewDto(Request request){
        this.description = request.getDescription();
        this.accepted = request.getAccepted();
        this.cost = request.getCost();
        this.completed = request.getCompleted();
        this.reason = request.getReason();
        this.clientName = request.getClient().getName();
        this.clientPhone = request.getClient().getPhone();
        this.masterName = (request.getMaster()!=null) ? request.getMaster().getName(): null;
    }
}
