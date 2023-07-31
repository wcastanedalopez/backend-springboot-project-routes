package com.bezkoder.springjwt.services.servicesDtoController;

import com.bezkoder.springjwt.models.Assignment;
import com.bezkoder.springjwt.models.Registration;
import com.bezkoder.springjwt.models.Route;
import com.bezkoder.springjwt.models.dtos.AssignmentDTO;
import com.bezkoder.springjwt.models.dtos.RegistrationDTO;
import com.bezkoder.springjwt.models.dtos.RouteDTO;

import java.util.ArrayList;
import java.util.List;

public class ConvertToDTO {
    public static List<RouteDTO> convertToDtoListRoutes(List<Route> routes) {
        List<RouteDTO> routesDTO = new ArrayList<>();
        for (Route r : routes) {
            RouteDTO rAux = new RouteDTO();
            rAux.setId(r.getId());
            rAux.setName(r.getName());
            rAux.setSector(r.getSector());
            rAux.setSede(r.getSede());
            routesDTO.add(rAux);
        }
        return routesDTO;
    }

    public static List<AssignmentDTO> convertListAssignmentToListDTOs(List<Assignment> assignments) {
        // Convertir List<Assignment> a List<AssignmentDTO>
        List<AssignmentDTO> assignmentDTOs = new ArrayList<>();
        for (Assignment assignment : assignments) {
            AssignmentDTO assignmentDTO = new AssignmentDTO();
            assignmentDTO.setId(assignment.getId());
            assignmentDTO.setRoutes(convertToDtoListRoutes(assignment.getRoutes()));
            assignmentDTO.setTeamId(assignment.getTeam().getId());

            if (assignment.getRegistration() != null)
                assignmentDTO.setRegistrationId(assignment.getRegistration().getId());
            assignmentDTO.setDate(assignment.getDate());
            assignmentDTOs.add(assignmentDTO);
        }

        return assignmentDTOs;
    }

    public static List<RegistrationDTO> getRegistrationsDTOs(List<Registration> registrations) {
        List<RegistrationDTO> registrationDTOS = new ArrayList<>();
        for (Registration registration : registrations) {
            RegistrationDTO registrationDTOAux = new RegistrationDTO();
            registrationDTOAux.setId(registration.getId());

            if (registration.getAssignments().size() > 0) {
                //System.out.println(registration.getAssignments().get(0).getRoutes());

                List<AssignmentDTO> aDTOS = convertListAssignmentToListDTOs(registration.getAssignments());
//                System.out.println("------ PRINTING IN GET REGISTERS THE ASSIGNMENTS LIST registration.getAssignments()------------");
//                for (Assignment a : registration.getAssignments()) {
//                    System.out.println(a.getId() + " - "  + a.getDate());
//                }
//
//                System.out.println("------ PRINTING IN GET REGISTERS THE ASSIGN DTOS LIST convertListAssignmentToListDTOs(registration.getAssignments())------------");
//                for (AssignmentDTO i : aDTOS) {
//                    System.out.println(i.getId() + " - "  + i.getDate());
//                }
                System.out.println("------ PRINTING SIZE: [ASS: " + " " + registration.getAssignments().size() + "]; [ASSDTOS: " + aDTOS.size() +  "] ------------");

                registrationDTOAux.setAssignments(aDTOS);
            }

            registrationDTOAux.setCreatedAt(registration.getCreatedAt());
            registrationDTOS.add(registrationDTOAux);
        }
        return registrationDTOS;
    }
}
