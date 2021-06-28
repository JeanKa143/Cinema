/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
/**
 *
 * @author diana
 */
package servicios;

import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Cliente;
import modelo.bd.FacturaBD;
import modelo.conjuntos.ConjuntoClientes;
import modelo.conjuntos.ConjuntoFactura;
import modelo.conjuntos.ConjuntoUsuarios;
import org.json.JSONObject;

/**
 *
 * @author diana
 */
@Path("/compras")
public class ServicioListaCompras {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getListaCompras(@PathParam("id") String id) {
       FacturaBD f = FACTURAS.getFactura(Integer.parseInt(id));

        if (f == null) {
            throw new NotFoundException();
        }

        return f.toJSON().toString();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void setCompra(String datosDeCompra) {
       JSONObject datos = new JSONObject(datosDeCompra);
        
        Date fecha = new Date();
        Cliente cliente = CLIENTES.getCliente(datos.getString("cliente_id"));

        System.out.println(datos.getInt("seq_factura"));
        System.out.println(fecha);
        System.out.println( cliente.getTarjeta_pago());
        System.out.println(cliente.getId());
        System.out.println(cliente.getIdCliente());
            
        FacturaBD factura = new FacturaBD(datos.getInt("seq_factura"), fecha, cliente.getTarjeta_pago(),
        cliente.getId(), cliente.getIdCliente());
        FACTURAS.agregarFactura(factura);

    }
   
    private static final ConjuntoFactura FACTURAS = new ConjuntoFactura();
    private static final ConjuntoClientes CLIENTES = new ConjuntoClientes();
}
