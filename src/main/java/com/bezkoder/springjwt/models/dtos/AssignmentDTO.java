package com.bezkoder.springjwt.models.dtos;

import com.bezkoder.springjwt.models.Route;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDTO {
    private long id;
    private List<RouteDTO> routes;
    private Long teamId;
    private Long registrationId;
    private LocalDate date;

    public AssignmentDTO() {
        this.routes = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<RouteDTO> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDTO> routes) {
        this.routes = routes;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
