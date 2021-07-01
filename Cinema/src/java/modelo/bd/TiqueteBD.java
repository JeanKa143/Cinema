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

import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author Luis Fallas
 */
public class TiqueteBD {

    private int id_tiquete;
    private double monto;
    private char asiento_funcion_fila;
    private int asiento_funcion_posicion;
    private int asiento_funcion_funcion_id;
    private Date asiento_funcion_funcion_fecha;
    private int asiento_funcion_funcion_sala_cinema_id;
    private int asiento_funcion_funcion_sala_numero;

    public TiqueteBD(int id_tiquete, double monto, char asiento_funcion_fila, int asiento_funcion_posicion, int asiento_funcion_funcion_id, Date asiento_funcion_funcion_fecha, int asiento_funcion_funcion_sala_cinema_id, int asiento_funcion_funcion_sala_numero) {
        this.id_tiquete = id_tiquete;
        this.monto = monto;
        this.asiento_funcion_fila = asiento_funcion_fila;
        this.asiento_funcion_posicion = asiento_funcion_posicion;
        this.asiento_funcion_funcion_id = asiento_funcion_funcion_id;
        this.asiento_funcion_funcion_fecha = asiento_funcion_funcion_fecha;
        this.asiento_funcion_funcion_sala_cinema_id = asiento_funcion_funcion_sala_cinema_id;
        this.asiento_funcion_funcion_sala_numero = asiento_funcion_funcion_sala_numero;
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        r.put("id_tiquete", id_tiquete);
        r.put("monto", monto);
        r.put("asiento_funcion_fila", Character.toString(asiento_funcion_fila));
        r.put("asiento_funcion_posicion", asiento_funcion_posicion);
        r.put("asiento_funcion_funcion_id", asiento_funcion_funcion_id);
        r.put("asiento_funcion_funcion_fecha", format.format(asiento_funcion_funcion_fecha));
        r.put("asiento_funcion_funcion_sala_cinema_id", asiento_funcion_funcion_sala_cinema_id);
        r.put("asiento_funcion_funcion_sala_numero", asiento_funcion_funcion_sala_numero);

        return r;
    }

    /**
     * @return the id_tiquete
     */
    public int getId_tiquete() {
        return id_tiquete;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @return the asiento_funcion_fila
     */
    public char getAsiento_funcion_fila() {
        return asiento_funcion_fila;
    }

    /**
     * @return the asiento_funcion_posicion
     */
    public int getAsiento_funcion_posicion() {
        return asiento_funcion_posicion;
    }

    /**
     * @return the asiento_funcion_funcion_id
     */
    public int getAsiento_funcion_funcion_id() {
        return asiento_funcion_funcion_id;
    }

    /**
     * @return the asiento_funcion_funcion_fecha
     */
    public Date getAsiento_funcion_funcion_fecha() {
        return asiento_funcion_funcion_fecha;
    }

    /**
     * @return the asiento_funcion_funcion_sala_cinema_id
     */
    public int getAsiento_funcion_funcion_sala_cinema_id() {
        return asiento_funcion_funcion_sala_cinema_id;
    }

    /**
     * @return the asiento_funcion_funcion_sala_numero
     */
    public int getAsiento_funcion_funcion_sala_numero() {
        return asiento_funcion_funcion_sala_numero;
    }

    /**
     * @param id_tiquete the id_tiquete to set
     */
    public void setId_tiquete(int id_tiquete) {
        this.id_tiquete = id_tiquete;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @param asiento_funcion_fila the asiento_funcion_fila to set
     */
    public void setAsiento_funcion_fila(char asiento_funcion_fila) {
        this.asiento_funcion_fila = asiento_funcion_fila;
    }

    /**
     * @param asiento_funcion_posicion the asiento_funcion_posicion to set
     */
    public void setAsiento_funcion_posicion(int asiento_funcion_posicion) {
        this.asiento_funcion_posicion = asiento_funcion_posicion;
    }

    /**
     * @param asiento_funcion_funcion_id the asiento_funcion_funcion_id to set
     */
    public void setAsiento_funcion_funcion_id(int asiento_funcion_funcion_id) {
        this.asiento_funcion_funcion_id = asiento_funcion_funcion_id;
    }

    /**
     * @param asiento_funcion_funcion_fecha the asiento_funcion_funcion_fecha to
     * set
     */
    public void setAsiento_funcion_funcion_fecha(Date asiento_funcion_funcion_fecha) {
        this.asiento_funcion_funcion_fecha = asiento_funcion_funcion_fecha;
    }

    /**
     * @param asiento_funcion_funcion_sala_cinema_id the
     * asiento_funcion_funcion_sala_cinema_id to set
     */
    public void setAsiento_funcion_funcion_sala_cinema_id(int asiento_funcion_funcion_sala_cinema_id) {
        this.asiento_funcion_funcion_sala_cinema_id = asiento_funcion_funcion_sala_cinema_id;
    }

    /**
     * @param asiento_funcion_funcion_sala_numero the
     * asiento_funcion_funcion_sala_numero to set
     */
    public void setAsiento_funcion_funcion_sala_numero(int asiento_funcion_funcion_sala_numero) {
        this.asiento_funcion_funcion_sala_numero = asiento_funcion_funcion_sala_numero;
    }

}
