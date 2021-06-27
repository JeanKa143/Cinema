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

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Luis Fallas
 */
@ApplicationPath("api")
public class RegistroAplicacion extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(Cartelera.class);
        classes.add(ServicioCliente.class);
        classes.add(ServicioLogin.class);
        classes.add(ServicioAsientos.class);
        classes.add(ServicioSalas.class);
        classes.add(ServicioPeliculas.class);
        classes.add(ServicioFunciones.class);
        classes.add(ServicioFacturas.class);
        classes.add(ServicioListaCompras.class);
        return classes;
    }

}
