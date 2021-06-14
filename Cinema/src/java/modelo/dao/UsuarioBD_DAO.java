/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package modelo.dao;

import db.dao.AbstractDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.bd.UsuarioBD;
import modelo.dao.crud.UsuarioBD_CRUD;

/**
 *
 * @author diana
 */
public class UsuarioBD_DAO extends AbstractDAO<Integer, UsuarioBD> {
    public UsuarioBD_DAO() throws Exception {
        super(new ModeloBD(), new UsuarioBD_CRUD());

    }

    @Override
    public UsuarioBD getRecord(ResultSet rs) throws SQLException {
        return new UsuarioBD(rs.getString("id_usuario"),
                rs.getString("clave"),
                rs.getInt("rol"));

    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, UsuarioBD value) throws SQLException {
        stm.setString(1, String.valueOf(id));
        stm.setString(2, value.getClave());
        stm.setInt(3, value.getRol());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, UsuarioBD value) throws SQLException {
        stm.setString(1, value.getClave());
        stm.setInt(2, value.getRol());
        stm.setInt(3, id);
    }
}
