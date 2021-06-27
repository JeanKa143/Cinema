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
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
                new Date(rs.getTimestamp("fecha").getTime()),
                rs.getInt("sala_cinema_id"),
                rs.getInt("sala_numero"),
                rs.getString("pelicula_id"));

    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, FuncionBD value) throws SQLException {
        stm.setTimestamp(1, new java.sql.Timestamp(value.getFecha().getTime()));
        stm.setInt(2, value.getSala_cinema_id());
        stm.setInt(3, value.getSala_numero());
        stm.setString(4, value.getPelicula_id());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, FuncionBD value) throws SQLException {
        stm.setTimestamp(1, new java.sql.Timestamp(value.getFecha().getTime()));
        stm.setInt(2, value.getSala_cinema_id());
        stm.setInt(3, value.getSala_numero());
        stm.setString(4, value.getPelicula_id());
        stm.setInt(5, id);
    }

    public int add(FuncionBD value) throws SQLException, IOException {
        try (Connection cnx = this.getDatabase().getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getAddCmd(), PreparedStatement.RETURN_GENERATED_KEYS)) {
            stm.clearParameters();
            setAddParameters(stm, value.getId_funcion(), value);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
            ResultSet rs = stm.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
}
