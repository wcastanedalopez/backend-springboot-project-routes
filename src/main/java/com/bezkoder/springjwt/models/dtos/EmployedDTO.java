package com.bezkoder.springjwt.models.dtos;

public class EmployedDTO {
    private Long id;
    private String username;
    private String phone;
    private String name;
    private String lastName;
    private String email;
    private TeamDTO team;

    public EmployedDTO(Long id, String username, String phone, String name, String lastName, String email, TeamDTO team) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.team = team;
    }

    public EmployedDTO() {
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

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }
}
