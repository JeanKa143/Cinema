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

    public void agregarPelicula(Pelicula pelicula) throws SQLException, IOException {
        peliculas.add(pelicula.getId_pelicula(), new PeliculaBD(pelicula));
    }

    public Pelicula getPelicula(String peliculaId) throws SQLException, IOException {
        PeliculaBD peliculaBD = peliculas.retrieve(peliculaId);

        if (peliculaBD != null) {
            return new Pelicula(peliculaBD.getId_pelicula(), peliculaBD.getTitulo(), peliculaBD.getPoster_path(),
                    peliculaBD.getMovie_data());
        }

        return null;
    }

    public List<Pelicula> getListaPeliculas() throws SQLException, IOException {
        List<PeliculaBD> pelicualasBD = peliculas.listAll();
        List<Pelicula> listaPeliculas = new ArrayList<>();

        for (PeliculaBD p : pelicualasBD) {
            listaPeliculas.add(new Pelicula(p.getId_pelicula(), p.getTitulo(), p.getPoster_path(), p.getMovie_data()));
        }

        return listaPeliculas;
    }

    private PeliculaBD_DAO peliculas;
}
