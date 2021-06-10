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

public class Tiquete {
    private int id_tiquete;
    private AsientoSalaFuncion asiento;
    private double monto;

    /**
     * @return the id_tiquete
     */
    public int getId_tiquete() {
        return id_tiquete;
    }

    /**
     * @return the asiento
     */
    public AsientoSalaFuncion getAsiento() {
        return asiento;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param id_tiquete the id_tiquete to set
     */
    public void setId_tiquete(int id_tiquete) {
        this.id_tiquete = id_tiquete;
    }

    /**
     * @param asiento the asiento to set
     */
    public void setAsiento(AsientoSalaFuncion asiento) {
        this.asiento = asiento;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }
}
