/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package modelo;

import java.util.Date;
import java.util.List;

public class Funcion {
    private Date fecha;
    private Pelicula pelicula;
    private List<AsientoSalaFuncion> asientoSalaFuncion;

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @return the pelicula
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * @return the asientoSalaFuncion
     */
    public List<AsientoSalaFuncion> getAsientoSalaFuncion() {
        return asientoSalaFuncion;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @param pelicula the pelicula to set
     */
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    /**
     * @param asientoSalaFuncion the asientoSalaFuncion to set
     */
    public void setAsientoSalaFuncion(List<AsientoSalaFuncion> asientoSalaFuncion) {
        this.asientoSalaFuncion = asientoSalaFuncion;
    }
}
