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
import modelo.bd.FuncionBD;
import modelo.dao.crud.FuncionBD_CRUD;

/**
 *
 * @author Luis Fallas
 */
public class FuncionBD_DAO extends AbstractDAO<Integer, FuncionBD> {

    public FuncionBD_DAO() throws Exception {
        super(new ModeloBD(), new FuncionBD_CRUD());

    }

    @Override
    public FuncionBD getRecord(ResultSet rs) throws SQLException {
        return new FuncionBD(rs.getInt("id_funcion"),
                rs.getDate("fecha"),
                rs.getInt("sala_cinema_id"),
                rs.getInt("sala_numero"),
                rs.getString("pelicula_id"));

    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, FuncionBD value) throws SQLException {
        stm.setInt(1, id);
        stm.setDate(2, value.getFecha());
        stm.setInt(3, value.getSala_cinema_id());
        stm.setInt(4, value.getSala_numero());
        stm.setString(5, value.getPelicula_id());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, FuncionBD value) throws SQLException {
        stm.setDate(1, value.getFecha());
        stm.setInt(2, value.getSala_cinema_id());
        stm.setInt(3, value.getSala_numero());
        stm.setString(4, value.getPelicula_id());
         stm.setInt(5, id);
    }

}
