/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package modelo.dao.crud;

import db.dao.crud.AbstractCRUD;

public class FacturaBD_CRUD extends AbstractCRUD {

    @Override
    public String getListAllCmd() {
        return LIST_CMD;
    }

    @Override
    public String getAddCmd() {
        return ADD_CMD;
    }

    @Override
    public String getRetrieveCmd() {
        return RETRIEVE_CMD;
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_CMD;
    }

    @Override
    public String getDeleteCmd() {
        return DELETE_CMD;
    }

    public String getListByParameterCmd(){
        return LIST_BY_PARAMETER_CMD;
    }
    
    protected static final String LIST_CMD
            = "SELECT "
            + "seq_factura, fecha, tarjeta_pago, cliente_usuario_id_usuario, cliente_id_cliente "
            + "FROM bd_cinema.factura ORDER BY fecha; ";

    protected static final String ADD_CMD
            = "INSERT INTO bd_cinema.factura "
            + "(fecha, tarjeta_pago, cliente_usuario_id_usuario, cliente_id_cliente) "
            + "VALUES (?, ?, ?, ?); ";

    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "seq_factura, fecha, tarjeta_pago, cliente_usuario_id_usuario, cliente_id_cliente "
            + "FROM bd_cinema.factura WHERE seq_factura = ?; ";

    protected static final String UPDATE_CMD
            = "UPDATE bd_cinema.factura "
            + "SET fecha = ?, tarjeta_pago = ?, cliente_usuario_id_usuario = ?, cliente_id_cliente = ? "
            + "WHERE seq_factura = ?; ";

    protected static final String DELETE_CMD
            = "DELETE FROM bd_cinema.factura "
            + "WHERE seq_factura = ?; ";
    
    protected static final String LIST_BY_PARAMETER_CMD
            = "SELECT "
            + "seq_factura, fecha, tarjeta_pago, cliente_usuario_id_usuario, cliente_id_cliente "
            + "FROM bd_cinema.factura WHERE cliente_id_cliente = ? ORDER BY fecha; ";
}
