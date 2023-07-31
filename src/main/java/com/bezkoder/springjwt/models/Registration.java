package com.bezkoder.springjwt.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "registers")
public class Registration {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @OneToMany( mappedBy = "registration" )
    private List<Assignment> assignments;

    public Registration() {
        this.createdAt = new Date();
        this.assignments = new ArrayList<>();
    }

    public Registration(long id, List<Assignment> assignments) {
        this.id = id;
        this.assignments = assignments;
        this.createdAt = new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", assignments=" + assignments +
                '}';
    }
}
