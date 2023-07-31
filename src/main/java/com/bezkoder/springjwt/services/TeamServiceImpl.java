package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Employed;
import com.bezkoder.springjwt.models.Team;
import com.bezkoder.springjwt.models.dtos.EmployedDTO;
import com.bezkoder.springjwt.models.dtos.TeamDTO;
import com.bezkoder.springjwt.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl {

    @Autowired
    ITeamRepository teamRepository;

    public List<Team> getTeams () {
        List<Team> all = teamRepository.findAll();
        System.out.println(all);
        return all;
    }

    public List<Team> saveTeams (List<Team> listTeams) {
        List<Team> all = teamRepository.saveAll(listTeams);
        return all;
    }


    public Team saveTeam (Team team) {
        return teamRepository.save(team);
    }

    public Optional<Team> getById (Long id) {
        return teamRepository.findById(id);
    }


    public List<Team> getByName (String name) {
        return teamRepository.findTeamByName(name);
    }

    public Team updateById (Team request, Long id) {
        Team aux = teamRepository.findById(id).get();
        aux.setName(request.getName());
        aux.setEmployedList(request.getEmployedList());
        aux.setAssignments(request.getAssignments());
        return aux;

    }

    public Boolean deleteById (Long id) {
        try {
            teamRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public Boolean deleteAll () {
        try {
            teamRepository.deleteAll();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    // Método para convertir una lista de objetos Team a una lista de TeamDTO
    public List<TeamDTO> convertToDTOList(List<Team> teamsAux) {
        List<TeamDTO> teamDTOList = new ArrayList<>();

        for (Team teamAux : teamsAux) {
            TeamDTO teamDTO = new TeamDTO();

            teamDTO.setId(teamAux.getId());
            teamDTO.setName(teamAux.getName());

            teamDTOList.add(teamDTO);
        }


        return teamDTOList;
    }

}
