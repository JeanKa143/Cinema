/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package modelo.conjuntos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cinema;
import modelo.bd.CinemaBD;
import modelo.dao.CinemaBD_DAO;

/**
 *
 * @author diana
 */
public class ConjuntoCinemas {
     public ConjuntoCinemas() {
        try {
            cinemas = new CinemaBD_DAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void agregarCinema(Cinema cinema) {
        try {
            cinemas.add(cinema.getIdCinema(), new CinemaBD(cinema));
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public Cinema getCinema(String cinema_id) {
        Cinema cinema = null;

        try {
            CinemaBD cinemaBD = cinemas.retrieve(Integer.parseInt(cinema_id));

            if (cinemaBD != null) {
                cinema = new Cinema(cinemaBD.getIdCinema(), cinemaBD.getNombre(), cinema.getDireccion(), null /*lista de salas*/);
            }
        } catch (IOException | IllegalArgumentException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return cinema;
    }

    public List<Cinema> getListaCinemas() {
        List<Cinema> listaCinemas = new ArrayList<>();

        try {
            List<CinemaBD> cinemasBD = cinemas.listAll();

            for (CinemaBD p : cinemasBD) {
                
                listaCinemas.add(new Cinema(p.getIdCinema(), p.getNombre(), p.getDireccion(), null /*lista de salas*/));
            }
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return listaCinemas;
    }

    private CinemaBD_DAO cinemas;
}
