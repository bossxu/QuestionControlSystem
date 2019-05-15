package com.questioncontrol.demo.Dto;


import javax.persistence.*;

@Entity
@Table(name = "persion")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(nullable = false)
    private  String userpwd;

    public User(String username,String userpwd) {
        this.username = username;
        this.userpwd = userpwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
}
