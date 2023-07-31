package com.bezkoder.springjwt.services;


import com.bezkoder.springjwt.models.Employed;
import com.bezkoder.springjwt.models.dtos.EmployedDTO;
import com.bezkoder.springjwt.models.dtos.TeamDTO;
import com.bezkoder.springjwt.repository.IEmployedRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployedService {

    @Autowired
    IEmployedRepository employedRepository;

    public List<Employed> getEmployees () {
        List<Employed> all = employedRepository.findAll();
        System.out.println("=====================    Imprimiendo empleados =========================================");
        System.out.println(all);
        return all;
    }

    public List<Employed> saveEmployees(List<Employed> listEmployees) {
        List<Employed> all = employedRepository.saveAll(listEmployees);
        return all;
    }


    public Employed saveEmployed (Employed user) {
        return employedRepository.save(user);
    }

    public Optional<Employed> getById (Long id) {
        return employedRepository.findById(id);
    }

    public Employed updateById (Employed request, Long id) {
        Employed aux = employedRepository.findById(id).get();
        aux.setName(request.getName());
        aux.setPassword(request.getPassword());
        aux.setEmail(request.getEmail());
        aux.setUsername(request.getUsername());
        aux.setLastName(request.getLastName());
        employedRepository.save(aux);
        return aux;

    }

    public Boolean deleteById (Long id) {
        try {
            employedRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public Boolean deleteAll () {
        try {
            employedRepository.deleteAll();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    // Método para convertir una lista de objetos Employed a una lista de EmployedDTO
    public List<EmployedDTO> convertToDTOList(List<Employed> employedList) {
        List<EmployedDTO> employedDTOList = new ArrayList<>();

        for (Employed employed : employedList) {
            EmployedDTO employedDTO = new EmployedDTO();

            employedDTO.setEmail(employed.getEmail());
            employedDTO.setId(employed.getId());
            employedDTO.setName(employed.getName());
            employedDTO.setLastName(employed.getLastName());
            employedDTO.setUsername(employed.getUsername());
            employedDTO.setPhone(employed.getPhone());

            if (employed.getTeam() != null) {
                System.out.println("------------ Id team: "+ employed.getTeam().getId() + " ---- Name team: " + employed.getTeam().getName());

                TeamDTO aux = new TeamDTO(employed.getTeam().getId(), employed.getTeam().getName());
                employedDTO.setTeam(aux);
            } else {
                employedDTO.setTeam(new TeamDTO(0L, "No equipment"));

            }


            employedDTOList.add(employedDTO);
        }

        return employedDTOList;
    }
}
