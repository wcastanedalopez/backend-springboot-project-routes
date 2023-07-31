package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Route;
import com.bezkoder.springjwt.repository.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl {

    @Autowired
    IRouteRepository routeRepository;

    public List<Route> getRoutes () {
        List<Route> all = routeRepository.findAll();
        return all;
    }

    public List<Route> saveRoutes (List<Route> listRoutes) {
        List<Route> all = routeRepository.saveAll(listRoutes);
        return all;
    }


    public Route saveRoute (Route route) {
        return routeRepository.save(route);
    }

    public Optional<Route> getById (Long id) {
        return routeRepository.findById(id);
    }

    public Route updateById (Route request, Long id) {
        Route aux = routeRepository.findById(id).get();
        aux.setName(request.getName());
        aux.setSector(request.getSector());
        aux.setSede(request.getSede());
        aux.setAssignment(request.getAssignment());
        routeRepository.save(aux);
        return aux;
    }



    public Boolean deleteById (Long id) {
         try {
             routeRepository.deleteById(id);
             return true;
         }catch (Exception e) {
             return false;
         }
    }
    public Boolean deleteAll () {
        try {
            routeRepository.deleteAll();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

}
