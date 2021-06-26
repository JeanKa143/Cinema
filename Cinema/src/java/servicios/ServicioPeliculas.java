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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Pelicula;
import modelo.conjuntos.ConjuntoPelicula;
import org.json.JSONObject;

/**
 *
 * @author Luis Fallas
 */
@Path("/peliculas")

public class ServicioPeliculas {

    @GET
    @Path("{idPelicula}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPelicula(@PathParam("idPelicula") String id) {
        Pelicula p = PELICULA.getPeliculaPorTitulo(id);

        if (p == null) {
            throw new NotFoundException();
        }

        return p.toJSON().toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPelicula(String pelicula) {
        Pelicula c = new Pelicula(new JSONObject(pelicula));
        try {
            PELICULA.agregarPelicula(c);
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePelicula(String pelicula) {
        Pelicula p = new Pelicula(new JSONObject(pelicula));

        try {
            PELICULA.actualizarPelicula(p);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw new InternalServerErrorException();
        }

    }

    private static final ConjuntoPelicula PELICULA = new ConjuntoPelicula();

}
