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
import modelo.Usuario;
import modelo.bd.UsuarioBD;
import modelo.conjuntos.ConjuntoUsuarios;
import org.json.JSONObject;

/**
 *
 * @author Luis Fallas
 */
@Path("/login")
public class ServicioLogin {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsuario(@PathParam("id") String idUsu) {
        ConjuntoUsuarios USUARIOS = new ConjuntoUsuarios();
        try {
            return toJSON(USUARIOS.getUsuario(idUsu)).toString();

        } catch (Exception ex) {
            throw new NotFoundException();
        }
    }
    
    public JSONObject toJSON(Usuario x) {
        JSONObject r = new JSONObject();

        r.put("id", x.getId());
        r.put("password", x.getClave());
        r.put("rol", x.getRol());

        return r;
    }

  
}
