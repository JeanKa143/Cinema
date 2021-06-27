/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package servicios;

/**
 *
 * @author diana
 */
/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */

import java.text.ParseException;
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
import org.json.JSONObject;

@Path("/facturas")
public class ServicioFacturas {

    @GET
    @Path("{getFactura}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFactura(@PathParam("id") int id) {
        FacturaBD c = FACTURAS.getFactura(id);

        if (c == null) {
            throw new NotFoundException();
        }

        return c.toJSON().toString();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("agregarFactura") 
    public void addFactura(String factura) {
        Date date = new Date();
        FacturaBD c = new FacturaBD(new JSONObject(factura));
        c.setFecha(date);
        Cliente cliente = CLIENTES.getCliente(c.getCliente_id());
        c.setTarjeta_pago(cliente.getTarjeta_pago());  
        FACTURAS.agregarFactura(c);
    }
    

    private static final ConjuntoFactura FACTURAS = new ConjuntoFactura();
    private static final ConjuntoClientes CLIENTES = new ConjuntoClientes();

}

