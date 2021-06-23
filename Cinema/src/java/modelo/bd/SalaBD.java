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

import org.json.JSONObject;

/**
 *
 * @author Luis Fallas
 */
public class SalaBD {
    private int cinema_id;
    private int numero;
    private int capacidad;

    public SalaBD(int cinema_id, int numero, int capacidad) {
        this.cinema_id = cinema_id;
        this.numero = numero;
        this.capacidad = capacidad;
    }

    public SalaBD(JSONObject j){
        this(1,j.getInt("numero"),j.getInt("capacidad"));
    }
    
    /**
     * @return the cinema_id
     */
    public int getCinema_id() {
        return cinema_id;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param cinema_id the cinema_id to set
     */
    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
