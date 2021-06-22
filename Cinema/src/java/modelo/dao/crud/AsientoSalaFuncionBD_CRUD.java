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

public class AsientoSalaFuncionBD_CRUD extends AbstractCRUD{

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
    
    public String getListByParameterCmd(){
        return LIST_BY_PARAMETER_CMD;
    }
    
    protected static final String LIST_CMD
            = "SELECT "
            + "fila, posicion, funcion_id, funcion_fecha, funcion_sala_cinema_id, funcion_sala_numero, ocupado "
            + "FROM bd_cinema.asiento_funcion ORDER BY funcion_fecha; ";
    
    protected static final String ADD_CMD
            = "INSERT INTO bd_cinema.asiento_funcion "
            + "(fila, posicion, funcion_id, funcion_fecha, funcion_sala_cinema_id, funcion_sala_numero, ocupado) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?); ";
    
    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "fila, posicion, funcion_id, funcion_fecha, funcion_sala_cinema_id, funcion_sala_numero, ocupado "
            + "FROM bd_cinema.asiento_funcion WHERE fila = ? AND posicion = ? AND funcion_id = ?; ";
    
    protected static final String UPDATE_CMD
            = "UPDATE bd_cinema.asiento_funcion "
            + "SET ocupado = ? "
            + "WHERE fila = ? AND posicion = ? AND funcion_id = ?; ";
    
    protected static final String DELETE_CMD
            = "DELETE FROM bd_cinema.asiento_funcion "
            + "WHERE fila = ? AND posicion = ? AND funcion_id = ?; ";
    
    protected static final String LIST_BY_PARAMETER_CMD
            = "SELECT "
            + "fila, posicion, funcion_id, funcion_fecha, funcion_sala_cinema_id, funcion_sala_numero, ocupado "
            + "FROM bd_cinema.asiento_funcion WHERE funcion_id = ? ORDER BY fila, posicion ASC; ";
}
