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

import modelo.bd.TiqueteBD;
import modelo.dao.crud.TiqueteBD_CRUD;

/**
 *
 * @author Luis Fallas
 */
public class TiqueteBD_DAO extends AbstractDAO<Integer, TiqueteBD> {

    public TiqueteBD_DAO() throws Exception {
        super(new ModeloBD(), new TiqueteBD_CRUD());

    }

    @Override
    public TiqueteBD getRecord(ResultSet rs) throws SQLException {

        return new TiqueteBD(
        rs.getInt("id_tiquete"),
        rs.getDouble("monto"),
        rs.getString("asiento_funcion_fila").charAt(0),
        rs.getInt("asiento_funcion_posicion"),
        rs.getInt("asiento_funcion_funcion_id"),
        rs.getDate("asiento_funcion_funcion_fecha"),
        rs.getInt("asiento_funcion_funcion_sala_cinema_id"),
        rs.getInt("asiento_funcion_funcion_sala_numero"));

    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, TiqueteBD value) throws SQLException {
        stm.setInt(1, id);
        stm.setDouble(2, value.getMonto());
        stm.setString(3, String.valueOf(value.getAsiento_funcion_fila()));
        stm.setInt(4, value.getAsiento_funcion_posicion());
        stm.setInt(5, value.getAsiento_funcion_funcion_id());
        stm.setDate(6, value.getAsiento_funcion_funcion_fecha());
        stm.setInt(7, value.getAsiento_funcion_funcion_sala_cinema_id());
        stm.setInt(8, value.getAsiento_funcion_funcion_sala_numero());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, TiqueteBD value) throws SQLException {
  
        stm.setDouble(1, value.getMonto());
        stm.setString(2, String.valueOf(value.getAsiento_funcion_fila()));
        stm.setInt(3, value.getAsiento_funcion_posicion());
        stm.setInt(4, value.getAsiento_funcion_funcion_id());
        stm.setDate(5, value.getAsiento_funcion_funcion_fecha());
        stm.setInt(6, value.getAsiento_funcion_funcion_sala_cinema_id());
        stm.setInt(7, value.getAsiento_funcion_funcion_sala_numero());
        stm.setInt(8, id);
    }

}
