/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package modelo;

import java.io.Serializable;
import java.util.Date;

public class Factura implements Serializable {
//3, "12-05-2021", cl.getTarjeta_pago(), cl.getId(), cl.getIdCliente()
    public Factura(int id_factura, Date fecha, String tarjeta_pago, Cliente cliente) {
        this.id_factura = id_factura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.tarjeta_pago = tarjeta_pago;
    }

    public Factura() {
        this(0, null, null, null);
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private int id_factura;
    private Date fecha;
    private Cliente cliente;
    private String tarjeta_pago;

    public String getTarjeta_pago() {
        return tarjeta_pago;
    }

    public void setTarjeta_pago(String tarjeta_pago) {
        this.tarjeta_pago = tarjeta_pago;
    }
}
