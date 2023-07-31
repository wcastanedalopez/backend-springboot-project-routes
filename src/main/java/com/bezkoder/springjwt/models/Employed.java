package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employed {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private String phone;
    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String email;

    @ManyToOne()
    private Team team;

    public Employed(Long id, String username, String password, String phone, String name, String lastName, String email, Team team) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.team = team;
    }

    public Employed() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
