package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Registration;
import com.bezkoder.springjwt.models.dtos.AssignmentDTO;
import com.bezkoder.springjwt.models.dtos.RegistrationDTO;
import com.bezkoder.springjwt.services.RegistrationServiceImpl;
import com.bezkoder.springjwt.services.servicesDtoController.ConvertToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/registration")
//@RepositoryRestResource(path = "registers", collectionResourceRel = "registers")
@CrossOrigin
public class RegistrationController {


    @Autowired
    private RegistrationServiceImpl registrationServiceImpl;

    @GetMapping(path = "/getAssignmentsByIdRegister/{id}")
    public List<AssignmentDTO> getListAssignmentsByIdRegister(@PathVariable Long id) {
        return ConvertToDTO.convertListAssignmentToListDTOs(registrationServiceImpl.getListAssignmentsByIdRegister(id));

    }

    @GetMapping
    public List<RegistrationDTO> getRegisters(){
        List<Registration> registrations = this.registrationServiceImpl.getRegisters();
        //System.out.println("IMPRIMIENDO EN CONTROLADOR --> " + registrations.get(13).getAssignments().get(0).getRoutes());


        return ConvertToDTO.getRegistrationsDTOs(registrations);
    }

    @PostMapping
    public Registration saveRegister(@RequestBody Registration register){
        return this.registrationServiceImpl.saveRegister(register);
    }

    @PostMapping(path = "/addList")
    public List<Registration> saveByListRegisters(@RequestBody List<Registration> registers){
        return this.registrationServiceImpl.saveRegisters(registers);
    }

    @GetMapping (path = "/{id}")
    public Optional<Registration> getRegisterById(@PathVariable Long id) {
        return this.registrationServiceImpl.getById(id);
    }

    @PostMapping(path = "/{id}")
    public Registration updateRegisterById (@RequestBody Registration register, Long id ) {
        return this.registrationServiceImpl.updateById(register, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRegisterById ( @PathVariable ("id") Long id) {
        boolean ok = this.registrationServiceImpl.deleteById(id);

        if (ok ) {
            return "Register with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete register with this id";
        }
    }

    @DeleteMapping
    public String deleteRegisters () {
        boolean ok = this.registrationServiceImpl.deleteAll();

        if (ok ) {
            return "All registers were eliminated";
        } else {
            return "Error, we have a problem for delete registers with this id";
        }
    }






}
