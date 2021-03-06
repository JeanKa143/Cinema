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

/**
 *
 * @author Luis Fallas
 */
public class SalaBD_CRUD extends AbstractCRUD{

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
            + "cinema_id, numero, capacidad "
            + "FROM bd_cinema.sala ORDER BY numero; ";

    protected static final String ADD_CMD
            = "INSERT INTO bd_cinema.sala "
            + "(cinema_id, numero, capacidad) "
            + "VALUES (?, ?, ?); ";

    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "cinema_id, numero, capacidad "
            + "FROM bd_cinema.sala WHERE numero = ?; ";

    protected static final String UPDATE_CMD
            = "UPDATE bd_cinema.sala "
            + "SET cinema_id = ?, capacidad = ? "
            + "WHERE numero = ?; ";

    protected static final String DELETE_CMD
            = "DELETE FROM bd_cinema.sala "
            + "WHERE numero = ?; ";
    
}
