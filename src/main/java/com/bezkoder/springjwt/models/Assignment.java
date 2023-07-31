package com.bezkoder.springjwt.models;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToMany( mappedBy = "assignment" )
    private List<Route> routes;


    @ManyToOne()
    private Team team;

    @ManyToOne()
    private Registration registration;

    @Column
    private LocalDate date;

    public Assignment() {
        this.routes = new ArrayList<>();
        this.registration = new Registration();
        this.team = new Team();
    }

    public Assignment(long id, List<Route> routes, Team team, Registration registration, LocalDate date) {
        this.id = id;
        this.routes = routes;
        this.team = team;
        this.registration = registration;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", routes=" + routes +
                ", team=" + team +
                ", registration=" + registration +
                ", date=" + date +
                '}';
    }
}
