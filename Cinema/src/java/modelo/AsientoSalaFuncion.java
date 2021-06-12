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

import java.io.Serializable;

public class AsientoSalaFuncion implements Serializable {

    public AsientoSalaFuncion(char fila, int posicion, boolean disponible) {
        this.fila = fila;
        this.posicion = posicion;
        this.disponible = disponible;
    }

    public AsientoSalaFuncion() {
        this(' ', 0, false);
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    private char fila;
    private int posicion;
    private boolean disponible;
}
