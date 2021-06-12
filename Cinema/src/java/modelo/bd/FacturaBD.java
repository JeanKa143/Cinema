/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package modelo.bd;

import java.io.Serializable;
import java.util.Date;
import modelo.Factura;

public class FacturaBD implements Serializable {

    public FacturaBD(int seq_factura, Date fecha, String tarjeta_pago, String cliente_id, String cliente_usuario_id) {
        this.seq_factura = seq_factura;
        this.fecha = fecha;
        this.tarjeta_pago = tarjeta_pago;
        this.cliente_id = cliente_id;
        this.cliente_usuario_id = cliente_usuario_id;
    }

    public FacturaBD(Factura factura) {
//        this(
//                factura.getId_factura(),
//                factura.getFecha(),
//                factura.getCliente().getTarjetaPago(),
//                factura.getCliente().getId(),
//                factura.getCliente().getIdUsuario()
//        );
        throw new UnsupportedOperationException();
    }

    public int getSeq_factura() {
        return seq_factura;
    }

    public void setSeq_factura(int seq_factura) {
        this.seq_factura = seq_factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTarjeta_pago() {
        return tarjeta_pago;
    }

    public void setTarjeta_pago(String tarjeta_pago) {
        this.tarjeta_pago = tarjeta_pago;
    }

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_usuario_id() {
        return cliente_usuario_id;
    }

    public void setCliente_usuario_id(String cliente_usuario_id) {
        this.cliente_usuario_id = cliente_usuario_id;
    }

    private int seq_factura;
    private Date fecha;
    private String tarjeta_pago;
    private String cliente_id;
    private String cliente_usuario_id;
}
