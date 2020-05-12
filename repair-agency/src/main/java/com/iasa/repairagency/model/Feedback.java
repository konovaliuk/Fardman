package com.iasa.repairagency.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User author;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Request request;


    private String text;

}
