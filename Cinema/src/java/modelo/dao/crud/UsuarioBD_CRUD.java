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
 * @author diana
 */
public class UsuarioBD_CRUD  extends AbstractCRUD{
    
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
            + "id_usuario, clave, rol "
            + "FROM bd_cinema.usuario ORDER BY id_usuario; ";

    protected static final String ADD_CMD
            = "INSERT INTO bd_cinema.usuario "
            + "(id_usuario, clave, rol) "
            + "VALUES (?, ?, ?); ";

    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "id_usuario, clave, rol "
            + "FROM bd_cinema.usuario WHERE id_usuario = ?; ";

    protected static final String UPDATE_CMD
            = "UPDATE bd_cinema.usuario "
            + "SET clave = ?, rol = ? "
            + "WHERE id_usuario = ?; ";

    protected static final String DELETE_CMD
            = "DELETE FROM bd_cinema.usuario "
            + "WHERE id_usuario = ?; ";
}
