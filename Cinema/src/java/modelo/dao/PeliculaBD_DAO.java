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
import modelo.bd.PeliculaBD;
import modelo.dao.crud.PeliculaBD_CRUD;

public class PeliculaBD_DAO extends AbstractDAO<String, PeliculaBD> {

    public PeliculaBD_DAO() throws Exception {
        super(new ModeloBD(), new PeliculaBD_CRUD());
    }

    @Override
    public PeliculaBD getRecord(ResultSet rs) throws SQLException {
        return new PeliculaBD(
                rs.getString("id_pelicula"),
                rs.getString("titulo"),
                rs.getString("poster_path"),
                rs.getObject("movie_data", String.class)
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, String id, PeliculaBD value) throws SQLException {
        stm.setString(1, id);
        stm.setString(2, value.getTitulo());
        stm.setString(3, value.getPoster_path());
        stm.setObject(4, value.getMovie_data());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, PeliculaBD value) throws SQLException {
        stm.setString(1, value.getTitulo());
        stm.setString(2, value.getPoster_path());
        stm.setObject(3, value.getMovie_data());
        stm.setString(4, id);
    }
}
