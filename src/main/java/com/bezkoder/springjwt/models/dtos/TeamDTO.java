package com.bezkoder.springjwt.models.dtos;

import java.util.List;

public class TeamDTO {
    private Long id;
    private String name;

    //private List<EmployedDTO> employeesList;

    public TeamDTO(Long id, String name) {//, List<EmployedDTO> employeesList) {
        this.id = id;
        this.name = name;
        //this.employeesList = employeesList;
    }




    public TeamDTO() {
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

}
