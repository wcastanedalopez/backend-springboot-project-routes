package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.Assignment;
import com.bezkoder.springjwt.models.dtos.AssignmentDTO;
import com.bezkoder.springjwt.services.AssignmentServiceImpl;
import com.bezkoder.springjwt.services.otherServicesController.SaveInBD;
import com.bezkoder.springjwt.services.servicesDtoController.ConvertToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {
    @Autowired
    private AssignmentServiceImpl assignmentServiceImpl;

    @Autowired
    private SaveInBD saveInBD;


    @PostMapping(path = "/generate")
    public List<AssignmentDTO> generateAssignments(
            @RequestParam("date_begin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date_begin,
            @RequestParam("date_end") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date_end
    ) {
        List<Assignment> assignments = new ArrayList<>();
        //List<Assignment> assignments = new ArrayList<>();
        if (!assignmentServiceImpl.getAssignments().isEmpty()) {
            //assignmentServiceImpl.deleteAll(); //It is necessary to clean the list so that it is not concatenated to the previous one.
            assignments = new ArrayList<>();
        }
        assignments = assignmentServiceImpl.generateAssignments(date_begin, date_end);

        saveInBD.saveRegister(assignments.get(assignments.size()-1).getRegistration()); //Save in BD a Register

        List<Assignment> assignmentsBD = assignmentServiceImpl.saveAssignments(assignments); //Saving in bd

        saveInBD.updateRoutesListByListAssignments(assignmentsBD);

        return ConvertToDTO.convertListAssignmentToListDTOs(assignments); //Return only dtos to avoid bucle error backend
    }

    @GetMapping
    public List<AssignmentDTO> getAssignments() {
        return ConvertToDTO.convertListAssignmentToListDTOs(this.assignmentServiceImpl.getAssignments());
    }

    @PostMapping
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return this.assignmentServiceImpl.saveAssignment(assignment);
    }

    @PostMapping(path = "/addList")
    public List<Assignment> saveByListAssignments(@RequestBody List<Assignment> assignments) {
        return this.assignmentServiceImpl.saveAssignments(assignments);
    }

    @GetMapping(path = "/{id}")
    public Optional<Assignment> getAssignmentById(@PathVariable Long id) {
        return this.assignmentServiceImpl.getById(id);
    }

    @PostMapping(path = "/{id}")
    public Assignment updateAssignmentById(@RequestBody Assignment assignment, Long id) {
        return this.assignmentServiceImpl.updateById(assignment, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRouteById(@PathVariable("id") Long id) {
        boolean ok = this.assignmentServiceImpl.deleteById(id);

        if (ok) {
            return "Assignment with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete assignment with this id";
        }
    }

    @DeleteMapping
    public String deleteRoutes() {
        boolean ok = this.assignmentServiceImpl.deleteAll();

        if (ok) {
            return "All assignments were eliminated";
        } else {
            return "Error, we have a problem for delete assignments with this id";
        }
    }
}
