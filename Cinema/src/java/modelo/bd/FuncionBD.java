/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package modelo.bd;

import java.util.Date;

/**
 *
 * @author Luis Fallas
 */
public class FuncionBD {
    private int id_funcion;
    private Date fecha;
    private int sala_cinema_id;
    private int sala_numero;
    private String pelicula_id;

    public FuncionBD(int id_funcion, Date fecha, int sala_cinema_id, int sala_numero, String pelicula_id) {
        this.id_funcion = id_funcion;
        this.fecha = fecha;
        this.sala_cinema_id = sala_cinema_id;
        this.sala_numero = sala_numero;
        this.pelicula_id = pelicula_id;
    }

    /**
     * @return the id_funcion
     */
    public int getId_funcion() {
        return id_funcion;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @return the sala_cinema_id
     */
    public int getSala_cinema_id() {
        return sala_cinema_id;
    }

    /**
     * @return the sala_numero
     */
    public int getSala_numero() {
        return sala_numero;
    }

    /**
     * @return the pelicula_id
     */
    public String getPelicula_id() {
        return pelicula_id;
    }

    /**
     * @param id_funcion the id_funcion to set
     */
    public void setId_funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @param sala_cinema_id the sala_cinema_id to set
     */
    public void setSala_cinema_id(int sala_cinema_id) {
        this.sala_cinema_id = sala_cinema_id;
    }

    /**
     * @param sala_numero the sala_numero to set
     */
    public void setSala_numero(int sala_numero) {
        this.sala_numero = sala_numero;
    }

    /**
     * @param pelicula_id the pelicula_id to set
     */
    public void setPelicula_id(String pelicula_id) {
        this.pelicula_id = pelicula_id;
    }
    
}
