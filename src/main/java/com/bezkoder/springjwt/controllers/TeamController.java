package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Team;
import com.bezkoder.springjwt.models.dtos.TeamDTO;
import com.bezkoder.springjwt.services.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/team")
//@RepositoryRestResource(path = "teams", collectionResourceRel = "teams")
public class TeamController {

    @Autowired
    private TeamServiceImpl teamServiceImpl;

    @GetMapping
    public List<TeamDTO> getTeams(){
        List<Team> auxListTeams = this.teamServiceImpl.getTeams();
        List<TeamDTO> listTeamsDTO = this.teamServiceImpl.convertToDTOList(auxListTeams);
        //return this.teamServiceImpl.getTeams();
        return listTeamsDTO;
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team team){
        return this.teamServiceImpl.saveTeam(team);
    }

    @PostMapping(path = "/addList")
    public List<Team> saveByListTeams(@RequestBody List<Team> teams){
        return this.teamServiceImpl.saveTeams(teams);
    }

    @GetMapping (path = "/{id}")
    public Optional<Team> getTeamById(@PathVariable Long id) {
        return this.teamServiceImpl.getById(id);
    }

    @GetMapping (path = "/findByName/{name}")
    public List<Team> getTeamByName(@PathVariable String name) {
        return this.teamServiceImpl.getByName(name);
    }

    @PostMapping(path = "/{id}")
    public Team updateTeamById (@RequestBody Team team, Long id ) {
        return this.teamServiceImpl.updateById(team, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTeamById ( @PathVariable ("id") Long id) {
        boolean ok = this.teamServiceImpl.deleteById(id);

        if (ok ) {
            return "Team with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete team with this id";
        }
    }

    @DeleteMapping
    public String deleteTeams () {
        boolean ok = this.teamServiceImpl.deleteAll();

        if (ok ) {
            return "All teams were eliminated";
        } else {
            return "Error, we have a problem for delete teams with this id";
        }
    }





}
