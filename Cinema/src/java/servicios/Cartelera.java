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

        ConjuntoPelicula conjunto = new ConjuntoPelicula();
        return conjunto.getListaPeliculas();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Pelicula buscarPeliculaID(@PathParam("id") String nombre) {
        try {
            ConjuntoPelicula conjunto = new ConjuntoPelicula();
            return conjunto.getPelicula(nombre);
        } catch (Exception ex) {
            throw new NotFoundException();
        }
    }  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void agregarPelicula(Pelicula p) {
        try {
            ConjuntoPelicula conjunto = new ConjuntoPelicula();
            conjunto.agregarPelicula(p);
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("filtrar")
    public List<Pelicula> filtrar() {
        ConjuntoPelicula conjunto = new ConjuntoPelicula();
        List<Pelicula> todos = conjunto.getListaPeliculas();
        List<Pelicula> filtrados = new ArrayList<>();
        for (Pelicula p : todos) {
            if (p.getCartelera().equals(true)) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }

}
