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
import java.util.ArrayList;
import java.util.List;
import modelo.AsientoSalaFuncion;
import modelo.bd.AsientoSalaFuncionBD;
import modelo.dao.crud.AsientoSalaFuncionBD_CRUD;

public class AsientoSalaFuncionBD_DAO extends AbstractDAO<Integer, AsientoSalaFuncionBD> {

    public AsientoSalaFuncionBD_DAO() throws Exception {
        super(new ModeloBD(), new AsientoSalaFuncionBD_CRUD());
    }

    @Override
    public AsientoSalaFuncionBD getRecord(ResultSet rs) throws SQLException {
        return new AsientoSalaFuncionBD(
                rs.getString("fila").charAt(0),
                rs.getInt("posicion"),
                rs.getInt("funcion_id"),
                new java.util.Date(rs.getDate("funcion_fecha").getTime()),
                rs.getInt("funcion_sala_cinema_id"),
                rs.getInt("funcion_sala_numero"),
                rs.getInt("ocupado") == 1
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, AsientoSalaFuncionBD value) throws SQLException {
        stm.setString(1, String.valueOf(value.getFila()));
        stm.setInt(2, value.getPosicion());
        stm.setInt(3, value.getFuncion_id());
        stm.setDate(4, new java.sql.Date(value.getFuncion_fecha().getTime()));
        stm.setInt(5, value.getFuncion_sala_cinema_id());
        stm.setInt(6, value.getFuncion_sala_numero());
        stm.setInt(7, (value.isOcupado() ? 1 : 0));
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, AsientoSalaFuncionBD value) throws SQLException {
        stm.setInt(1, (value.isOcupado() ? 1 : 0));
        stm.setString(2, String.valueOf(value.getFila()));
        stm.setInt(3, value.getPosicion());
        stm.setInt(4, value.getFuncion_id());
    }

    public List<AsientoSalaFuncionBD> listAllByFuncion(int funcion_id) throws SQLException, IOException {
        List<AsientoSalaFuncionBD> r = new ArrayList<>();
        AsientoSalaFuncionBD m;
        try (Connection cnx = getDatabase().getConnection();
                PreparedStatement stm = cnx.prepareStatement(((AsientoSalaFuncionBD_CRUD) getCRUD()).getListByParameterCmd())) {
            stm.clearParameters();
            stm.setInt(1, funcion_id);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    m = getRecord(rs);
                    r.add(m);
                }
            }
        }
        return r;
    }

    public AsientoSalaFuncionBD retrieve(char fila, int posicion, int funcion_id) throws SQLException, IOException, IllegalArgumentException {
        AsientoSalaFuncionBD r = null;
        try (Connection cnx = getDatabase().getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getRetrieveCmd())) {
            stm.clearParameters();
            stm.setString(1, String.valueOf(fila));
            stm.setInt(2, posicion);
            stm.setInt(3, funcion_id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = getRecord(rs);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return r;
    }

    /**
     * @param id
     * @return
     * @deprecated
     */
    @Override
    public AsientoSalaFuncionBD retrieve(Integer id) {
        throw new UnsupportedOperationException();
    }
}
