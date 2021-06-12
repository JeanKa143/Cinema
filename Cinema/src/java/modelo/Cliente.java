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
import java.util.List;

public class Cliente extends Usuario {
    
    private String id;
    private String clave;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String tarjeta_pago;
    private List<Factura> facturas;
 
    public Cliente(){
       super();
    }
   
    public Cliente(String id, String clave, Rol rol, String nombre, String apellidos, String telefono, String tarjeta_pago,
            List<Factura> facturas){
        
        super(id, clave, rol);
        this.id = super.getId();
        this.clave = super.getClave();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.tarjeta_pago = tarjeta_pago;
        this.facturas = facturas;
    }
 
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setTarjetaPago(String tarjeta_pago){
        this.tarjeta_pago = tarjeta_pago;
    }
    
    public void setFacturas(List<Factura> facturas){
        this.facturas = facturas;
    }
    
    public void setRol(Rol rol){
        super.setRol(rol);
    }
    
    public void setClave(String clave){
        super.setClave(clave);
    }
    
    public void setId(String id){
        super.setId(id);
    }
    
    public Rol getRol(){
        return super.getRol();   
    }
    
    public String getId(){
        return super.getId();
    }
    
    public String getClave(){
        return super.getClave();
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellidos(){
        return this.apellidos;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    public String getTarjetaPago(){
        return this.tarjeta_pago;
    }
    
    public List<Factura> getListaFacturas(){
        return this.facturas;
    }

}
