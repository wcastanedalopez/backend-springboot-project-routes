package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.Route;
import com.bezkoder.springjwt.services.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/route")
//@RepositoryRestResource(path = "routes", collectionResourceRel = "routes")
public class RouteController {

    @Autowired
    private RouteServiceImpl routeServiceImpl;

    @GetMapping
    public List<Route> getRoutes(){
        return this.routeServiceImpl.getRoutes();
    }

    @PostMapping
    public Route saveRoute(@RequestBody Route route){
        return this.routeServiceImpl.saveRoute(route);
    }

    @PostMapping(path = "/addList")
    public List<Route> saveByListRoutes(@RequestBody List<Route> routes){
        return this.routeServiceImpl.saveRoutes(routes);
    }

    @GetMapping (path = "/{id}")
    public Optional<Route> getRouteById(@PathVariable Long id) {
        return this.routeServiceImpl.getById(id);
    }

    @PostMapping(path = "/{id}")
    public Route updateRouteById (@RequestBody Route user, Long id ) {
         return this.routeServiceImpl.updateById(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRouteById ( @PathVariable ("id") Long id) {
        boolean ok = this.routeServiceImpl.deleteById(id);

        if (ok ) {
            return "Route with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete route with this id";
        }
    }

    @DeleteMapping
    public String deleteRoutes () {
        boolean ok = this.routeServiceImpl.deleteAll();

        if (ok ) {
            return "All routes were eliminated";
        } else {
            return "Error, we have a problem for delete route with this id";
        }
    }





}
