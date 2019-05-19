package com.questioncontrol.demo.Dto;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    // 0 试题录入员
    // 1 试题查询员
    // 2 人员管理员
    @Id
    @GeneratedValue
    private Integer id = 0;

    @Column(name = "username")
    private String username;

    @Column(name = "userpwd")
    private  String userpwd;

    @Column(name = "usertype")
    private int usertype = 0;

    public User(String username,String userpwd,int usertype) {
        this.id = 0;
        this.username = username;
        this.userpwd = userpwd;
        this.usertype = usertype;
    }
    public User(){
        this.id = 0;
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ",username="+username+
                ", usertype=" + usertype +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
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
