package com.bezkoder.springjwt.models.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrationDTO {
    private long id;
    private List<AssignmentDTO> assignments;

    private Date createdAt;


    public RegistrationDTO() {
        this.assignments = new ArrayList<>();
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

    public List<AssignmentDTO> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentDTO> assignments) {
        this.assignments = assignments;
    }
}
