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

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.bd.TiqueteBD;
import modelo.conjuntos.ConjuntoTiquetes;

/**
 *
 * @author JeanKa
 */
@Path("/tiquetes")
public class ServicioTiquetes {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTiquete(@PathParam("id") String id) {
        TiqueteBD t = TIQUETES.obtener2(Integer.parseInt(id));

        if (t == null) {
            throw new NotFoundException();
        }

        return t.toJSON().toString();
    }

    private static final ConjuntoTiquetes TIQUETES = new ConjuntoTiquetes();
}
