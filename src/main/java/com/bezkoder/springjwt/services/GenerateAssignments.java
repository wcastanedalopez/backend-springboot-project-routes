package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Assignment;
import com.bezkoder.springjwt.models.Registration;
import com.bezkoder.springjwt.models.Route;
import com.bezkoder.springjwt.models.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateAssignments {


    public static List<Assignment> generate (List<Route> routes, List<Team> teams, LocalDate date_start, LocalDate date_end ) {
        //Map<LocalDate, List<Assignment>> assignmentsA = GenerateAssignments.getAssignments(routes, teams, date_start, date_end);

        Map<LocalDate, Assignment> assignmentsA = GenerateAssignments.getAssignmentsNew(routes, teams, date_start, date_end);
        List<Assignment> assignments = convertMapToListNew(assignmentsA);

        return assignments;
    }


    /**
     * Este método guarda una ruta por asignación, no resulta óptimo
     * @param rutas
     * @param equipos
     * @param date_start
     * @param date_end
     * @return
     */
    public static Map<LocalDate, List<Assignment>> getAssignments(List<Route> rutas, List<Team> equipos,  LocalDate date_start, LocalDate date_end) {
        Map<LocalDate, List<Assignment>> asignaciones = new HashMap<>();

        int equipoIndex = 0, assIndex = 0;

        for (int rutaIndex = 0; rutaIndex < rutas.size(); rutaIndex++) {
            Route ruta = rutas.get(rutaIndex);
            Team equipo = equipos.get(equipoIndex);

            if (!asignaciones.containsKey(date_start)) {
                asignaciones.put(date_start, new ArrayList<>());
            }

            Assignment aux = new Assignment();
            aux.setId(assIndex);
            aux.setDate(date_start);
            aux.setTeam(equipo);
            aux.getRoutes().add(ruta);
            //asignaciones.get(fecha).add(ruta + " - " + equipo);
            asignaciones.get(date_start).add(aux);

            if (asignaciones.get(date_start).size() == 2) {
                equipoIndex = (equipoIndex + 1) % equipos.size();
                date_start = siguienteFecha(date_start);
                assIndex++;
            }

            if (rutaIndex == rutas.size()-1) {
                rutaIndex = -1;
            }

            if (date_start.equals(date_end)) {
                break;
            }


        }

        return asignaciones;
    }

    /**
     * Permite incluir dos rutas en una sola asignación
     * @param rutas
     * @param equipos
     * @param date_start
     * @param date_end
     * @return
     */
    public static Map<LocalDate, Assignment> getAssignmentsNew(List<Route> rutas, List<Team> equipos,  LocalDate date_start, LocalDate date_end) {
        Map<LocalDate, Assignment> asignaciones = new HashMap<>();

        int equipoIndex = 0, assIndex = 0;

        for (int rutaIndex = 0; rutaIndex < rutas.size(); rutaIndex++) {
            Route ruta = rutas.get(rutaIndex);
            Team equipo = equipos.get(equipoIndex);

            if (!asignaciones.containsKey(date_start)) {
                asignaciones.put(date_start, new Assignment());
                //asignaciones.get(date_start).setId(assIndex);
                asignaciones.get(date_start).setDate(date_start);
                asignaciones.get(date_start).setTeam(equipo);
            }

            asignaciones.get(date_start).getRoutes().add(ruta);
            //System.out.println("Date_Start: " + date_start + " ---- Date_End: " + date_end);

            if (asignaciones.get(date_start).getRoutes().size() == 2) {
                System.out.println("Asignación NO. " + assIndex + ". With routes: " + asignaciones.get(date_start).getRoutes().isEmpty());
                equipoIndex = (equipoIndex + 1) % equipos.size();
                date_start = siguienteFecha(date_start);
                assIndex++;
            }

            if (rutaIndex == rutas.size()-1) {
                rutaIndex = -1;
            }

            if (date_start.equals(date_end)) {
                break;
            }
        }
        return asignaciones;
    }

    public static Map<LocalDate, List<Assignment>> asignarRutasAEquipos(List<Route> rutas, List<Team> equipos) {
        Map<LocalDate, List<Assignment>> asignaciones = new HashMap<>();
        LocalDate fecha = LocalDate.of(2024, 1, 1);
        LocalDate date_end= LocalDate.of(2024, 2, 1);
        int equipoIndex = 0, assIndex = 0;

        for (int rutaIndex = 0; rutaIndex < rutas.size(); rutaIndex++) {
            Route ruta = rutas.get(rutaIndex);
            Team equipo = equipos.get(equipoIndex);

            if (!asignaciones.containsKey(fecha)) {
                asignaciones.put(fecha, new ArrayList<>());
            }

            Assignment aux = new Assignment();
            aux.setId(assIndex);
            aux.setDate(fecha);
            aux.setTeam(equipo);
            aux.getRoutes().add(ruta);
            //asignaciones.get(fecha).add(ruta + " - " + equipo);
            asignaciones.get(fecha).add(aux);

            if (asignaciones.get(fecha).size() == 2) {
                equipoIndex = (equipoIndex + 1) % equipos.size();
                fecha = siguienteFecha(fecha);
                assIndex++;
            }

            if (rutaIndex == rutas.size()-1) {
                rutaIndex = -1;
            }

            if (fecha.equals(date_end)) {
                break;
            }


        }

        return asignaciones;
    }

    public static LocalDate siguienteFecha(LocalDate fecha) {
        // Implementar lógica para obtener la siguiente fecha a partir de la fecha actual
        // Por ejemplo, para sumar un día a la fecha actual:
        return fecha.plusDays(1);
    }
    private static List<Assignment> convertMapToList(Map<LocalDate, List<Assignment>> assignmentsMap) {
        List<Assignment> assignmentsList = new ArrayList<>();

        // Recorrer las listas de asignaciones del mapa y agregarlas a la lista plana
        for (List<Assignment> assignments : assignmentsMap.values()) {
            assignmentsList.addAll(assignments);
        }

        return assignmentsList;
    }
    private static List<Assignment> convertMapToListNew(Map<LocalDate, Assignment> assignmentsMap) {
        List<Assignment> assignmentsList = new ArrayList<>();

        Registration registration = new Registration();
        // Recorrer las listas de asignaciones del mapa y agregarlas a la lista plana
        for (Assignment assignment : assignmentsMap.values()) {
            registration.getAssignments().add(assignment);
            assignment.setRegistration(registration);
            //System.out.println("Assignment: Id: " + assignment.getId() + " -- " + assignment.getRoutes());

            assignmentsList.add(assignment);
        }
//        for (int i = 0; i < assignmentsList.size(); i++) {
//            assignmentsList.get(i).getRegistration().setAssignments(assignmentsList);
//        }
        //registration.setAssignments(assignmentsList);

        return assignmentsList;
    }
}
