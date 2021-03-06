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
import modelo.Pelicula;
import modelo.bd.PeliculaBD;
import modelo.dao.PeliculaBD_DAO;

public class ConjuntoPelicula {

    public ConjuntoPelicula() {
        try {
            peliculas = new PeliculaBD_DAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void agregarPelicula(Pelicula pelicula) {
        try {
            peliculas.add(pelicula.getId_pelicula(), new PeliculaBD(pelicula));
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void actualizarPelicula(Pelicula pelicula) throws SQLException, IOException {
        peliculas.update(pelicula.getId_pelicula(), new PeliculaBD(pelicula));
    }

    public Pelicula getPeliculaPorTitulo(String titulo) {
        Pelicula pelicula = null;
        try {
            PeliculaBD peliculaBD = peliculas.retrieve(titulo.toLowerCase());

            if (peliculaBD != null) {
                pelicula = new Pelicula(peliculaBD.getId_pelicula(), peliculaBD.getTitulo(), peliculaBD.getPoster_path(),
                        peliculaBD.getMovie_data(), peliculaBD.getCartelera() == 1);

            }
        } catch (IOException | IllegalArgumentException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return pelicula;
    }

    public Pelicula getPeliculaPorId(String id) {
        Pelicula pelicula = null;

        try {
            PeliculaBD peliculaBD = peliculas.retrieveById(id);

            if (peliculaBD != null) {
                pelicula = new Pelicula(peliculaBD.getId_pelicula(), peliculaBD.getTitulo(), peliculaBD.getPoster_path(),
                        peliculaBD.getMovie_data(), peliculaBD.getCartelera() == 1);
            }
        } catch (IOException | IllegalArgumentException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return pelicula;
    }

    public List<Pelicula> getListaPeliculas() {
        List<Pelicula> listaPeliculas = new ArrayList<>();

        try {
            List<PeliculaBD> pelicualasBD = peliculas.listAll();

            for (PeliculaBD p : pelicualasBD) {
                listaPeliculas.add(new Pelicula(p.getId_pelicula(), p.getTitulo(), p.getPoster_path(), p.getMovie_data(),
                        p.getCartelera() == 1));
            }
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return listaPeliculas;
    }

    private PeliculaBD_DAO peliculas;
}
