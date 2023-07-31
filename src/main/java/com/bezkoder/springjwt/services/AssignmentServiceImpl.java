package com.bezkoder.springjwt.services;


import com.bezkoder.springjwt.models.Assignment;
import com.bezkoder.springjwt.models.Route;
import com.bezkoder.springjwt.models.Team;
import com.bezkoder.springjwt.models.dtos.AssignmentDTO;
import com.bezkoder.springjwt.repository.IAssignmentRepository;
import com.bezkoder.springjwt.repository.IRouteRepository;
import com.bezkoder.springjwt.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssignmentServiceImpl {

    @Autowired
    IAssignmentRepository assignmentRepository;

    @Autowired
    IRouteRepository iRouteRepository;

    @Autowired
    ITeamRepository iTeamRepository;

    public List<Assignment> getAssignments () {
        List<Assignment> all = assignmentRepository.findAll();
        return all;
    }

    public List<Assignment> saveAssignments(List<Assignment> listAssignments) {

        int cont = 0;
        for (Assignment a: listAssignments) {
            if (a.getRoutes().isEmpty()) {
                System.out.println("------------------- NO HAY RUTAS PARA MOSTRAR-----------------------");
            } else {
//                System.out.println("Assignment: Id: " + cont + "Routes: " + a.getRoutes());
//                cont++;

            }

        }

        List<Assignment> all = assignmentRepository.saveAll(listAssignments);
        return all;
    }


    public Assignment saveAssignment (Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Optional<Assignment> getById (Long id) {
        return assignmentRepository.findById(id);
    }

    public Assignment updateById (Assignment request, Long id) {
        Assignment aux = assignmentRepository.findById(id).get();
        aux.setDate(request.getDate());
        aux.setTeam(request.getTeam());
        aux.setRegistration(request.getRegistration());
        aux.setRoutes(request.getRoutes());
        assignmentRepository.save(aux);
        return aux;

    }

    public Boolean deleteById (Long id) {
        try {
            assignmentRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public Boolean deleteAll () {
        try {
            assignmentRepository.deleteAll();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public List<Assignment> generateAssignments(LocalDate dateBegin, LocalDate dateEnd) {


        List<Route> routes = iRouteRepository.findAll();
        System.out.println("Enviando " + routes.size() + " Routes");
        List<Team> teams = iTeamRepository.findAll();
        System.out.println("Enviando " + teams.size() + " Teams");

//        LocalDate date_start = LocalDate.of(2024, 1, 1);
//        LocalDate date_end= LocalDate.of(2024, 2, 1);

        List<Assignment> assignments = GenerateAssignments.generate(routes, teams, dateBegin, dateEnd);

        return assignments;
    }




}
