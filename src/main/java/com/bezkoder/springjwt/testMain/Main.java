package com.bezkoder.springjwt.testMain;

import com.bezkoder.springjwt.models.Assignment;
import com.bezkoder.springjwt.models.Route;
import com.bezkoder.springjwt.models.Team;
import com.bezkoder.springjwt.services.GenerateAssignments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<LocalDate, List<String>> asignarRutasAEquipos(List<String> rutas, List<String> equipos) {
        Map<LocalDate, List<String>> asignaciones = new HashMap<>();
        LocalDate fecha = LocalDate.of(2024, 1, 1);
        LocalDate date_end= LocalDate.of(2024, 2, 1);
        int equipoIndex = 0;

        for (int rutaIndex = 0; rutaIndex < rutas.size(); rutaIndex++) {
            String ruta = rutas.get(rutaIndex);
            String equipo = equipos.get(equipoIndex);

            if (!asignaciones.containsKey(fecha)) {
                asignaciones.put(fecha, new ArrayList<>());
            }

            asignaciones.get(fecha).add(ruta + " - " + equipo);

            if (asignaciones.get(fecha).size() == 2) {
                equipoIndex = (equipoIndex + 1) % equipos.size();
                fecha = siguienteFecha(fecha);
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

    public static void main(String[] args) {

        //runExampleChatGPT();
        //runExampleMe();
        //runExampleListAssignments();
        runTestNewWhitoutList();

    }

    private static void runTestNewWhitoutList() {
        List<Route> routesAux = generateDataTest();
        List<Team> teamsAux = generateTeamsExample();

        LocalDate fecha = LocalDate.of(2024, 1, 1);
        LocalDate date_end= LocalDate.of(2024, 2, 1);

        Map<LocalDate, Assignment> asignaciones = GenerateAssignments.getAssignmentsNew(routesAux, teamsAux, fecha, date_end);

        int aux = 0;
        // Mostrar las asignaciones por fecha
        for (Map.Entry<LocalDate, Assignment> entry : asignaciones.entrySet()) {
            LocalDate fechaAux = entry.getKey();
            Assignment assignment = entry.getValue();
            System.out.println("Fecha: " + fechaAux);
            System.out.println("Asignación -->  Team: " + assignment.getTeam().getId()
                    + " -- Routes: [ " + assignment.getRoutes().get(0).getId()
                    + ", " + assignment.getRoutes().get(1).getId() + " ]");

            System.out.println("------------------------");

        }
    }

    public static void runExampleListAssignments() {
        List<Route> routesAux = generateDataTest();
        List<Team> teamsAux = generateTeamsExample();

        LocalDate fecha = LocalDate.of(2024, 1, 1);
        LocalDate date_end= LocalDate.of(2024, 2, 1);

        List<Assignment> asignaciones = GenerateAssignments.generate(routesAux, teamsAux, fecha, date_end);
        for (Assignment assignment : asignaciones) {
            System.out.println(assignment.toString());
        }

    }

    private static void runExampleMe() {
        List<Route> routesAux = generateDataTest();
        List<Team> teamsAux = generateTeamsExample();

        Map<LocalDate, List<Assignment>> asignaciones = GenerateAssignments.asignarRutasAEquipos(routesAux, teamsAux);

        int aux = 0;
        // Mostrar las asignaciones por fecha
        for (Map.Entry<LocalDate, List<Assignment>> entry : asignaciones.entrySet()) {
            LocalDate fecha = entry.getKey();
            List<Assignment> rutasEquipos = entry.getValue();
            System.out.println("Fecha: " + fecha);
            for (Assignment rutaEquipo : rutasEquipos) {
                System.out.println("Asignación: " + rutaEquipo);
            }
            System.out.println("------------------------");

        }


    }

    private static List<Team> generateTeamsExample() {
        // Crear una lista de objetos Team
        List<Team> teamsList = new ArrayList<>();

        // Crear y agregar tres objetos Team a la lista
        for (int i = 1; i <= 3; i++) {
            Team team = new Team((long) i, "Equipo " + i, null, null);
            teamsList.add(team);
        }
        return teamsList;
    }

    private static List<Route> generateDataTest() {
        // Crear una lista de objetos Route
        List<Route> routesList = new ArrayList<>();

        // Crear y agregar diez objetos Route a la lista
        for (int i = 1; i <= 10; i++) {
            Route route = new Route((long) i, "Ruta " + i, "Sector " + i, "Sede " + i, null);
            routesList.add(route);
        }
        return routesList;
    }

    private static void runExampleChatGPT() {
        List<String> rutas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rutas.add("ruta_" + i);
        }

        List<String> equipos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            equipos.add("equipo_" + i);
        }

        Map<LocalDate, List<String>> asignaciones = asignarRutasAEquipos(rutas, equipos);

        int aux = 0;
        // Mostrar las asignaciones por fecha
        for (Map.Entry<LocalDate, List<String>> entry : asignaciones.entrySet()) {
            LocalDate fecha = entry.getKey();
            List<String> rutasEquipos = entry.getValue();
            System.out.println("Fecha: " + fecha);
            for (String rutaEquipo : rutasEquipos) {
                System.out.println("Asignación: " + rutaEquipo);
            }
            System.out.println("------------------------");

        }
    }
}
