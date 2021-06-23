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
import modelo.bd.SalaBD;
import modelo.dao.crud.SalaBD_CRUD;

/**
 *
 * @author Luis Fallas
 */
public class SalaBD_DAO extends AbstractDAO<Integer, SalaBD> {
    
    public SalaBD_DAO() throws Exception {
        super(new ModeloBD(), new SalaBD_CRUD());
        
    }
    
    @Override
    public SalaBD getRecord(ResultSet rs) throws SQLException {
        return new SalaBD(rs.getInt("cinema_id"),
                rs.getInt("numero"),
                rs.getInt("capacidad"));
    }
    
    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, SalaBD value) throws SQLException {
        stm.setInt(1, 1);
        stm.setInt(2, id);        
        stm.setInt(3, value.getCapacidad());
    }
    
    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, SalaBD value) throws SQLException {
        stm.setInt(1,1); 
        stm.setInt(2, value.getCapacidad());
        stm.setInt(3, id);
    }
    
}
