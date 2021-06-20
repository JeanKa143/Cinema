/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package modelo.dao.crud;

import db.dao.crud.AbstractCRUD;

public class PeliculaBD_CRUD extends AbstractCRUD {

    @Override
    public String getListAllCmd() {
        return LIST_CMD;
    }

    @Override
    public String getAddCmd() {
        return ADD_CMD;
    }

    @Override
    public String getRetrieveCmd() {
        return RETRIEVE_CMD;
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_CMD;
    }

    @Override
    public String getDeleteCmd() {
        return DELETE_CMD;
    }

    protected static final String LIST_CMD
            = "SELECT "
            + "id_pelicula, titulo, poster_path, movie_data, cartelera "
            + "FROM bd_cinema.pelicula ORDER BY titulo; ";

    protected static final String ADD_CMD
            = "INSERT INTO bd_cinema.pelicula "
            + "(id_pelicula, titulo, poster_path, movie_data, cartelera)"
            + "VALUES (?, ?, ?, ?, ?); ";

    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "id_pelicula, titulo, poster_path, movie_data, cartelera "
            + "FROM bd_cinema.pelicula WHERE titulo = ?; ";

    protected static final String UPDATE_CMD
            = "UPDATE bd_cinema.pelicula "
            + "SET titulo = ?, poster_path = ?, movie_data = ?, cartelera = ? "
            + "WHERE id_pelicula = ?; ";

    protected static final String DELETE_CMD
            = "DELETE FROM bd_cinema.pelicula "
            + "WHERE id_pelicula = ?; ";
}
