package com.bezkoder.springjwt.services.otherServicesController;

import com.bezkoder.springjwt.models.Assignment;
import com.bezkoder.springjwt.models.Registration;
import com.bezkoder.springjwt.models.Route;
import com.bezkoder.springjwt.services.AssignmentServiceImpl;
import com.bezkoder.springjwt.services.RegistrationServiceImpl;
import com.bezkoder.springjwt.services.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveInBD {
    @Autowired
    private RegistrationServiceImpl registrationService;

    @Autowired
    RouteServiceImpl routeService;
    @Autowired
    AssignmentServiceImpl assignmentService;

    public void saveRegister(Registration registration) {
        this.registrationService.saveRegister(registration);

    }

    public static void saveRoute(Route route) {

    }

    public void updateRoutesListByListAssignments(List<Assignment> assignments) {

        for (Assignment a : assignments) {

            List<Route> routes = a.getRoutes();

            if (!routes.isEmpty()) {
                for (Route r : routes) {
                    Route auxR = r;
                    auxR.setAssignment(a);
                    routeService.updateById(auxR, auxR.getId());
                }
            }

        }

    }

}

