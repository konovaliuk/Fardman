package com.iasa.repairagency.dto;

import com.iasa.repairagency.model.Request;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class RequestToViewFullDto {

    private String description;

    private Integer cost;

    private String reason;

    private Boolean accepted;

    private Boolean completed;

    private String clientName;

    private String clientPhone;

    private String masterName;

    private String masterPhone;

    private List<String> feedbacks;

    public RequestToViewFullDto(Request request){
        this.description = request.getDescription();
        this.accepted = request.getAccepted();
        this.cost = request.getCost();
        this.completed = request.getCompleted();
        this.reason = request.getReason();
        this.clientName = request.getClient().getName();
        this.clientPhone = request.getClient().getPhone();
        this.masterName = (request.getMaster()!=null) ? request.getMaster().getName(): null;
        this.feedbacks = request.getFeedbackList().stream().map(item -> String.join(" @", item.getText(), item.getAuthor().getName())).collect(Collectors.toList());
    }
}
