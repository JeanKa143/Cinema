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
public class TiqueteBD_CRUD extends AbstractCRUD{

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
            + "id_tiquete, monto, asiento_funcion_fila, asiento_funcion_posicion, asiento_funcion_funcion_id, asiento_funcion_funcion_fecha, asiento_funcion_funcion_sala_cinema_id, asiento_funcion_funcion_sala_numero "
            + "FROM bd_cinema.tiquete ORDER BY id_tiquete; ";

    protected static final String ADD_CMD
            = "INSERT INTO bd_cinema.tiquete "
            + "(id_tiquete, monto, asiento_funcion_fila, asiento_funcion_posicion, asiento_funcion_funcion_id, asiento_funcion_funcion_fecha, asiento_funcion_funcion_sala_cinema_id, asiento_funcion_funcion_sala_numero) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?); ";

    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "id_tiquete, monto, asiento_funcion_fila, asiento_funcion_posicion, asiento_funcion_funcion_id, asiento_funcion_funcion_fecha, asiento_funcion_funcion_sala_cinema_id, asiento_funcion_funcion_sala_numero "
            + "FROM bd_cinema.tiquete WHERE id_tiquete = ?; ";

    protected static final String UPDATE_CMD
            = "UPDATE bd_cinema.tiquete "
            + "SET  monto = ?, asiento_funcion_fila = ?, asiento_funcion_posicion = ?, asiento_funcion_funcion_id = ?, asiento_funcion_funcion_fecha = ?, asiento_funcion_funcion_sala_cinema_id = ?, asiento_funcion_funcion_sala_numero = ? "
            + "WHERE id_tiquete = ?; ";

    protected static final String DELETE_CMD
            = "DELETE FROM bd_cinema.tiquete "
            + "WHERE id_tiquete = ?; ";
    
}
