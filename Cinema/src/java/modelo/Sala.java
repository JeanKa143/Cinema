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

import java.util.List;

public class Sala {
    private int id_Sala;
    private int capacidad;
    private List<Funcion> funciones;
    
     public Sala(int id_Sala, int capacidad) {
        this.id_Sala = id_Sala;
        this.capacidad = capacidad;
        funciones=null;

    }

    /**
     * @return the id_Sala
     */
    public int getId_Sala() {
        return id_Sala;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @return the funciones
     */
    public List<Funcion> getFunciones() {
        return funciones;
    }

    /**
     * @param id_Sala the id_Sala to set
     */
    public void setId_Sala(int id_Sala) {
        this.id_Sala = id_Sala;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @param funciones the funciones to set
     */
    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }

    @Override
    public String toString() {
        
        return String.format("id_Sala: %d, capacidad: %s",getId_Sala(),getCapacidad());
    }
    
    
}
