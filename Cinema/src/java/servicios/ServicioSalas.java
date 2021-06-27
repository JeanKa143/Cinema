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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Sala;
import modelo.bd.SalaBD;
import modelo.conjuntos.ConjuntoSalas;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Luis Fallas
 */
@Path("/salas")
public class ServicioSalas {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSalas() {
        JSONArray r = new JSONArray();
        List<Sala> listaSalas = SALAS.getListaSalas();

        if (listaSalas.isEmpty()) {
            throw new NotFoundException();
        }

        for (Sala s : listaSalas) {
            r.put(toJSON(s));
        }

        return r.toString();
    }

    @GET
    @Path("{id_sala}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSala(@PathParam("id_sala") String id) {

        Sala c = SALAS.obtener(Integer.parseInt(id));

        if (c == null) {
            throw new NotFoundException();
        }

        return toJSON(c).toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCliente(String sala) {
        SalaBD s = new SalaBD(new JSONObject(sala));
        System.out.println(s.getCapacidad());
        System.out.println(s.getNumero());
        System.out.println(s.getCinema_id());
        try {
            SALAS.agregar(s);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioSalas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicioSalas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JSONObject toJSON(Sala x) {
        JSONObject r = new JSONObject();

        r.put("id", x.getId_Sala());
        r.put("capacidad", x.getCapacidad());

        return r;
    }
    private static final ConjuntoSalas SALAS = new ConjuntoSalas();

}
