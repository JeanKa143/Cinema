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
import modelo.bd.ClienteBD;
import modelo.dao.crud.ClienteBD_CRUD;

/**
 *
 * @author diana
 */
public class ClienteBD_DAO extends AbstractDAO<String, ClienteBD> {

    public ClienteBD_DAO() throws Exception {
        super(new ModeloBD(), new ClienteBD_CRUD());

    }

    @Override
    public ClienteBD getRecord(ResultSet rs) throws SQLException {
        return new ClienteBD(rs.getString("usuario_id_usuario"),
                rs.getString("id_cliente"),
                rs.getString("apellidos"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("tarjeta_pago"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm, String id, ClienteBD value) throws SQLException {
        stm.setString(1, id);
        stm.setString(2, value.getId_cliente());
        stm.setString(3, value.getApellidos());
        stm.setString(4, value.getNombre());
        stm.setString(5, value.getTelefono());
        stm.setString(6, value.getTarjeta_pago());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, ClienteBD value) throws SQLException {
        stm.setString(1, value.getUsuarioIdUsuario());
        stm.setString(2, value.getApellidos());
        stm.setString(3, value.getNombre());
        stm.setString(4, value.getTelefono());
        stm.setString(5, value.getTarjeta_pago());
        stm.setString(6, id);
    }
}
