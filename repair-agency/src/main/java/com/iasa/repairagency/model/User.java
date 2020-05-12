package com.iasa.repairagency.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity

@Table(name = "users")

public class User {


    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String login;

    private String password;

    private String name;
    private String phone;
    private String role;

    @OneToMany(mappedBy = "client")
    private List<Request> requests;

    @OneToMany(mappedBy = "master")
    private List<Request> masterRequests;

    @OneToMany(mappedBy = "manager")
    private List<Request> managerRequests;

    @OneToMany (mappedBy = "author")
    private List<Feedback> feedbacks;

    public User(String login, String password, String name, String phone, String role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.role = role;
    }

}
