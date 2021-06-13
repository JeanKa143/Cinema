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
import modelo.bd.AsientoSalaFuncionBD;

public class Tiquete {
    private int id_tiquete;
    private AsientoSalaFuncionBD asiento;
    private double monto;

    public Tiquete(int id_tiquete, AsientoSalaFuncionBD asiento, double monto) {
        this.id_tiquete = id_tiquete;
        this.asiento = asiento;
        this.monto = monto;
    }
    

    /**
     * @return the id_tiquete
     */
    public int getId_tiquete() {
        return id_tiquete;
    }

    /**
     * @return the asiento
     */
    public AsientoSalaFuncionBD getAsiento() {
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
    public void setAsiento(AsientoSalaFuncionBD asiento) {
        this.asiento = asiento;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }
}
