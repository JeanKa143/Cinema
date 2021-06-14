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
import modelo.bd.CinemaBD;
import modelo.dao.crud.CinemaBD_CRUD;

/**
 *
 * @author diana
 */
public class CinemaBD_DAO extends AbstractDAO<Integer, CinemaBD>{
     public CinemaBD_DAO() throws Exception {
        super(new ModeloBD(), new CinemaBD_CRUD());

    }

    @Override
    public CinemaBD getRecord(ResultSet rs) throws SQLException {
        return new CinemaBD(rs.getInt("id_cinema"),
                rs.getString("nombre"),
                rs.getString("direccion"));

    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, CinemaBD value) throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, value.getNombre());
        stm.setString(3, value.getDireccion());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, CinemaBD value) throws SQLException {
        stm.setString(1, value.getNombre());
        stm.setString(2, value.getDireccion());
        stm.setInt(3, id);
    }
}
