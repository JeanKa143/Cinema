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
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Cliente;
import modelo.Usuario;
import modelo.conjuntos.ConjuntoClientes;
import modelo.conjuntos.ConjuntoUsuarios;
import org.json.JSONObject;

@Path("/clientes")
public class ServicioCliente {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCliente(@PathParam("id") String id) {
        Cliente c = CLIENTES.getCliente(id);

        if (c == null) {
            throw new NotFoundException();
        }

        return c.toJSON().toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCliente(String cliente) {
        Cliente c = new Cliente(new JSONObject(cliente));

        try {
            USUARIOS.agregarUsuario((Usuario) c);
            CLIENTES.agregarCliente(c);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw new InternalServerErrorException();
        }
    }

    private static final ConjuntoClientes CLIENTES = new ConjuntoClientes();
    private static final ConjuntoUsuarios USUARIOS = new ConjuntoUsuarios();
}
