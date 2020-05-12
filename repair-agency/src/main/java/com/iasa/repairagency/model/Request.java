package com.iasa.repairagency.model;

import com.iasa.repairagency.dto.RequestToCreateDto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue
    private Long id;


    private String description;

    private Integer cost;

    private String reason;

    private Boolean accepted;

    private Boolean completed;


    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User client;


    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User master;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User manager;

    @OneToMany(mappedBy = "request")
    private List<Feedback> feedbackList;

    public Request(String description, User client, User manager){
        this.description = description;
        this.client = client;
        this.manager = manager;
    }


}

