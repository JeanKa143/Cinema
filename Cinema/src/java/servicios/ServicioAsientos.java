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

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.AsientoSalaFuncion;
import modelo.conjuntos.ConjuntoAsientoSalaFuncion;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("/asientos")
public class ServicioAsientos {

    @GET
    @Path("{funcionId}/{fila}/{posicion}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAsiento(@PathParam("funcionId") String funcionId, @PathParam("fila") String fila,
            @PathParam("posicion") String posicion) {

        AsientoSalaFuncion asiento = ASIENTOS.getAsiento(fila.charAt(0), Integer.parseInt(posicion), Integer.parseInt(funcionId));

        if (asiento == null) {
            throw new NotFoundException();
        }

        return asiento.toJSON().toString();
    }

    @GET
    @Path("{funcionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAsientosFuncion(@PathParam("funcionId") String funcionId) {

        JSONArray r = new JSONArray();
        List<AsientoSalaFuncion> lista = ASIENTOS.getListaAsientosFuncion(Integer.parseInt(funcionId));

        if (lista.isEmpty()) {
            throw new NotFoundException();
        }

        for (AsientoSalaFuncion a : lista) {
            r.put(a.toJSON());
        }

        return r.toString();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAsiento(String asiento) {
        try {
            ASIENTOS.actualizarAsiento(new AsientoSalaFuncion(new JSONObject(asiento)));
        } catch (SQLException | IOException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw new InternalServerErrorException();
        }
    }

    private static final ConjuntoAsientoSalaFuncion ASIENTOS = new ConjuntoAsientoSalaFuncion();
}
