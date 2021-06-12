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

import java.io.Serializable;
import java.util.Date;
import modelo.AsientoSalaFuncion;

public class AsientoSalaFuncionBD implements Serializable {

    public AsientoSalaFuncionBD(char fila, int posicion, int funcion_id, Date funcion_fecha, int funcion_sala_cinema_id,
            int funcion_sala_numero, boolean ocupado) {

        this.fila = fila;
        this.posicion = posicion;
        this.funcion_id = funcion_id;
        this.funcion_fecha = funcion_fecha;
        this.funcion_sala_cinema_id = funcion_sala_cinema_id;
        this.funcion_sala_numero = funcion_sala_numero;
        this.ocupado = ocupado;
    }

    public AsientoSalaFuncionBD(AsientoSalaFuncion asientoSalaFuncion, int funcion_id, Date funcion_fecha,
            int funcion_sala_cinema_id, int funcion_sala_numero) {
        this(
                asientoSalaFuncion.getFila(),
                asientoSalaFuncion.getPosicion(),
                funcion_id,
                funcion_fecha,
                funcion_sala_cinema_id,
                funcion_sala_numero,
                !asientoSalaFuncion.isDisponible()
        );
    }

    public AsientoSalaFuncionBD() {
        this(null, 0, null, 0, 0);
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

    public int getFuncion_id() {
        return funcion_id;
    }

    public void setFuncion_id(int funcion_id) {
        this.funcion_id = funcion_id;
    }

    public Date getFuncion_fecha() {
        return funcion_fecha;
    }

    public void setFuncion_fecha(Date funcion_fecha) {
        this.funcion_fecha = funcion_fecha;
    }

    public int getFuncion_sala_cinema_id() {
        return funcion_sala_cinema_id;
    }

    public void setFuncion_sala_cinema_id(int funcion_sala_cinema_id) {
        this.funcion_sala_cinema_id = funcion_sala_cinema_id;
    }

    public int getFuncion_sala_numero() {
        return funcion_sala_numero;
    }

    public void setFuncion_sala_numero(int funcion_sala_numero) {
        this.funcion_sala_numero = funcion_sala_numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    private char fila;
    private int posicion;
    private int funcion_id;
    private Date funcion_fecha;
    private int funcion_sala_cinema_id;
    private int funcion_sala_numero;
    private boolean ocupado;
}
