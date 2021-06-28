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

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.bd.FacturaBD;
import modelo.conjuntos.ConjuntoFactura;

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
   
    private static final ConjuntoFactura FACTURAS = new ConjuntoFactura();
}
