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
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.ws.rs.Consumes;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import modelo.AsientoSalaFuncion;
import modelo.Sala;
import modelo.bd.FuncionBD;
import modelo.conjuntos.ConjuntoAsientoSalaFuncion;
import modelo.conjuntos.ConjuntoFuncion;
import modelo.conjuntos.ConjuntoSalas;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author JeanKa
 */
@Path("/funciones")
public class ServicioFunciones {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addFuncion(String funcion) {
        JSONObject datos = new JSONObject(funcion);
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        int index = 0, aux = 1;
        int idFuncion;

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date fecha = format.parse(String.format("%s %s", datos.get("fecha"), datos.get("hora")));
            Sala sala = SALAS.obtener(datos.getInt("sala_numero"));
            idFuncion = FUNCIONES.agregar2(new FuncionBD(0, fecha, 1, sala.getId_Sala(), datos.getString("pelicula_id")));

            for (int i = 1; i <= sala.getCapacidad(); i++) {
                if (((i - 1) % 10) == 0 && i > 1) {
                    index++;
                    aux = 1;
                }
                ASIENTOS.agregarAsiento(new AsientoSalaFuncion(alfabeto.charAt(index), aux, true), idFuncion, fecha, 1, datos.getInt("sala_numero"));
                aux++;
            }
        } catch (IOException | SQLException | ParseException | JSONException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw new InternalServerErrorException();
        }
    }

    private static final ConjuntoFuncion FUNCIONES = new ConjuntoFuncion();
    private static final ConjuntoAsientoSalaFuncion ASIENTOS = new ConjuntoAsientoSalaFuncion();
    private static final ConjuntoSalas SALAS = new ConjuntoSalas();
}
