package com.bezkoder.springjwt.services;


import com.bezkoder.springjwt.models.Assignment;
import com.bezkoder.springjwt.models.Registration;
import com.bezkoder.springjwt.repository.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl {

    @Autowired
    IRegistrationRepository registrationRepository;

    public List<Registration> getRegisters () {
        List<Registration> all = registrationRepository.findAll();
        return all;
    }

    public List<Registration> saveRegisters (List<Registration> listRegisters) {
        List<Registration> all = registrationRepository.saveAll(listRegisters);
        return all;
    }


    public Registration saveRegister (Registration register) {
        return registrationRepository.save(register);
    }

    public Optional<Registration> getById (Long id) {
        return registrationRepository.findById(id);
    }

    public Registration updateById (Registration request, Long id) {
        Registration aux = registrationRepository.findById(id).get();
        aux.setAssignments(request.getAssignments());
        registrationRepository.save(aux);
        return aux;

    }

    public Boolean deleteById (Long id) {
        try {
            registrationRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public Boolean deleteAll () {
        try {
            registrationRepository.deleteAll();
            return true;
        }catch (Exception e) {
            return false;
        }
    }


    public Registration getLastRegister() {
        // Ordenar por fecha de creación en orden descendente y limitar el resultado a un solo registro
        Registration lastRegister= registrationRepository.findTopByOrderByCreatedAtDesc().orElse(null);

        // Si se encuentra algún registro, devolver el primero (el último por la ordenación)
        if (lastRegister != null) {
            return lastRegister;
        } else {
            return null;
        }
    }

    public List<Assignment> getListAssignmentsByIdRegister(Long id) {
          Registration aux = registrationRepository.findById(id).orElse(null);

          return aux == null ? new ArrayList<>() : aux.getAssignments();
    }
}
