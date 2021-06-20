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
import java.util.List;
import modelo.Usuario.Rol;
import org.json.JSONObject;

public class Cliente extends Usuario implements Serializable {

    private String idCliente;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String tarjeta_pago;
    private List<Factura> facturas;

    public Cliente(String idCliente, String nombre, String apellidos, String telefono, String tarjeta_pago,
            List<Factura> facturas, String id, String clave, Rol rol) {

        super(id, clave, rol);
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.tarjeta_pago = tarjeta_pago;
        this.facturas = facturas;
    }

    public Cliente(JSONObject j) {
        this(j.getString("idCliente"), j.getString("nombre"), j.getString("apellidos"), j.getString("telefono"),
                j.getString("tarjeta_pago"), null, j.getString("id"), j.getString("clave"), Rol.cliente);
    }

    public Cliente() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();

        r.put("idCliente", idCliente);
        r.put("nombre", nombre);
        r.put("apellidos", apellidos);
        r.put("telefono", telefono);
        r.put("tarjeta_pago", tarjeta_pago);
        r.put("id", this.getId());
        r.put("rol", this.getRol());

        return r;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTarjeta_pago() {
        return tarjeta_pago;
    }

    public void setTarjeta_pago(String tarjeta_pago) {
        this.tarjeta_pago = tarjeta_pago;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}
