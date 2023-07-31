package com.bezkoder.springjwt.models;


import javax.persistence.*;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @Column
    private String sector;

    @Column
    private String sede;
//
//    @Column
//    private String team_string;

//    @ManyToOne
//    private Team team;

    @ManyToOne()
    private Assignment assignment;


    public Route(Long id, String name, String sector, String sede, Assignment assignment) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.sede = sede;
        this.assignment = assignment;
    }

    public Route() {
        this.assignment = new Assignment();
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                ", sede='" + sede + '\'' +
                ", assignment=" + assignment +
                '}';
    }
}
