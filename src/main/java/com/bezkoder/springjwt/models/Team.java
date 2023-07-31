package com.bezkoder.springjwt.models;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

//    @OneToMany( mappedBy = "team" )
//    private List<Route> routes;

    @OneToMany( mappedBy = "team" )
    //@JsonIgnoreProperties("team")
    private List<Employed> employeesList;

    @OneToMany( mappedBy = "team" )
    private List<Assignment> assignments;

    public Team() {
    }

    public Team(Long id, String name, List<Employed> employeesList, List<Assignment> assignments) {
        this.id = id;
        this.name = name;
        this.employeesList = employeesList;
        this.assignments = assignments;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employed> getEmployedList() {
        return employeesList;
    }

    public void setEmployedList(List<Employed> employeesList) {
        this.employeesList = employeesList;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeesList=" + employeesList +
                ", assignments=" + assignments +
                '}';
    }
}
