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
import modelo.bd.FacturaBD;
import modelo.dao.crud.FacturaBD_CRUD;

public class FacturaBD_DAO extends AbstractDAO<Integer, FacturaBD> {

    public FacturaBD_DAO() throws Exception {
        super(new ModeloBD(), new FacturaBD_CRUD());
    }

    @Override
    public FacturaBD getRecord(ResultSet rs) throws SQLException {
        return new FacturaBD(
                rs.getInt("seq_factura"),
                rs.getDate("fecha"),
                rs.getString("tarjeta_pago"),
                rs.getString("cliente_id_cliente"),
                rs.getString("cliente_usuario_id_usuario")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, FacturaBD value) throws SQLException {
        //stm.setInt(1, id);
        stm.setTimestamp(1, new java.sql.Timestamp(value.getFecha().getTime()));
        stm.setString(2, value.getTarjeta_pago());
        stm.setString(3, value.getCliente_usuario_id());
        stm.setString(4, value.getCliente_id());
        
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, FacturaBD value) throws SQLException {
           
        stm.setTimestamp(1, new java.sql.Timestamp(value.getFecha().getTime()));
        stm.setString(2, value.getTarjeta_pago());
        stm.setString(3, value.getCliente_usuario_id());
        stm.setString(4, value.getCliente_id());
        stm.setInt(5, value.getSeq_factura());
    }


    public List<FacturaBD> listAllByCliente(String cliente_id) throws SQLException, IOException {
        List<FacturaBD> r = new ArrayList<>();
        FacturaBD m;
        try (Connection cnx = getDatabase().getConnection();
                PreparedStatement stm = cnx.prepareStatement(((FacturaBD_CRUD) getCRUD()).getListByParameterCmd())) {
            stm.clearParameters();
            stm.setString(1, cliente_id);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    m = getRecord(rs);
                    r.add(m);
                }
            }
        }
        return r;
    }
    
}
