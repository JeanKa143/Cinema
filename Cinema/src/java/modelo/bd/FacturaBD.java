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
import java.text.ParseException;
import modelo.Factura;
import org.json.JSONObject;

public class FacturaBD implements Serializable {

    public FacturaBD(int seq_factura, String fecha, String tarjeta_pago, String cliente_id, String cliente_usuario_id) {
        this.seq_factura = seq_factura;
        this.fecha = fecha;
        this.tarjeta_pago = tarjeta_pago;
        this.cliente_id = cliente_id;
        this.cliente_usuario_id = cliente_usuario_id;
    }
    
    public FacturaBD(JSONObject j) throws ParseException {

    this(Integer.parseInt(j.getString("seq_factura")), j.getString("fecha"), j.getString("tarjeta_pago"), j.getString("cliente_id"), j.getString("cliente_usuario_id"));
    }
    
 public JSONObject toJSON() {
        JSONObject r = new JSONObject();

        r.put("seq_factura", seq_factura);
        r.put("fecha", tarjeta_pago);
        r.put("tarjeta_pago", tarjeta_pago);
        r.put("cliente_id", cliente_id);
        r.put("cliente_usuario_id", cliente_usuario_id);

        return r;
    }

    public FacturaBD(Factura factura) {
        this(
                factura.getId_factura(),
                factura.getFecha(),
                factura.getCliente().getTarjeta_pago(),
                factura.getCliente().getId(),
                factura.getCliente().getIdCliente()
       );
        throw new UnsupportedOperationException();
    }
      
    public int getSeq_factura() {
        return seq_factura;
    }

    public void setSeq_factura(int seq_factura) {
        this.seq_factura = seq_factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
    private String fecha;
    private String tarjeta_pago;
    private String cliente_id;
    private String cliente_usuario_id;
}
