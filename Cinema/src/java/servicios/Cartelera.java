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

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Pelicula;
import modelo.conjuntos.ConjuntoPelicula;

/**
 *
 * @author Luis Fallas
 */
@Path("/cartelera")
public class Cartelera {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pelicula> listaPeliculas() {
        return PELICULAS.getListaPeliculas();
    }

    @GET
    @Path("{titulo}")
    @Produces({MediaType.APPLICATION_JSON})
    public Pelicula buscarPeliculaTitulo(@PathParam("titulo") String titulo) {
        try {
            return PELICULAS.getPeliculaPorTitulo(titulo);
        } catch (Exception ex) {
            throw new NotFoundException();
        }
    }

    @GET
    @Path("id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPeliculaPorId(@PathParam("id") String id) {
        Pelicula p = PELICULAS.getPeliculaPorId(id);

        if (p == null) {
            throw new NotFoundException();
        }

        return p.toJSON().toString();
    }

//    @GET
//    @Path("{cedula}/imagen")
//    @Produces("image/png")
//    public Response getImge(@PathParam("cedula") String cedula) throws IOException {
//        File file = new File(location+cedula);
//        ResponseBuilder response = Response.ok((Object) file);
//        return response.build();
//    }    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void agregarPelicula(Pelicula p) {
        try {
            PELICULAS.agregarPelicula(p);
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("filtrar")
    public List<Pelicula> filtrar() {
        List<Pelicula> todos = PELICULAS.getListaPeliculas();
        List<Pelicula> filtrados = new ArrayList<>();
        for (Pelicula p : todos) {
            if (p.getCartelera()) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }

    private static final ConjuntoPelicula PELICULAS = new ConjuntoPelicula();
}
