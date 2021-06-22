/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package modelo.conjuntos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.AsientoSalaFuncion;
import modelo.bd.AsientoSalaFuncionBD;
import modelo.dao.AsientoSalaFuncionBD_DAO;

public class ConjuntoAsientoSalaFuncion {

    public ConjuntoAsientoSalaFuncion() {
        try {
            this.asientos = new AsientoSalaFuncionBD_DAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void agregarAsiento(AsientoSalaFuncion asiento, int funcionId, Date funcionFecha, int funcionSalaCine,
            int funcionSalaNumero) {

        try {
            asientos.add(0, new AsientoSalaFuncionBD(asiento, funcionId, funcionFecha, funcionSalaCine, funcionSalaNumero));
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public AsientoSalaFuncion getAsiento(char fila, int posicion, int funcionId) {
        AsientoSalaFuncion asiento = null;

        try {
            AsientoSalaFuncionBD asientoBD = asientos.retrieve(fila, posicion, funcionId);

            if (asientoBD != null) {
                asiento = new AsientoSalaFuncion(asientoBD.getFila(), asientoBD.getPosicion(), !asientoBD.isOcupado());
            }
        } catch (IOException | IllegalArgumentException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return asiento;
    }
    
    public void actualizarAsiento(AsientoSalaFuncion asiento) throws SQLException, IOException{
        asientos.update(0, new AsientoSalaFuncionBD(asiento));
    }

    public List<AsientoSalaFuncion> getListaAsientos() {
        List<AsientoSalaFuncion> listasAsientos = new ArrayList<>();

        try {
            List<AsientoSalaFuncionBD> asientosBD = asientos.listAll();

            for (AsientoSalaFuncionBD a : asientosBD) {
                listasAsientos.add(new AsientoSalaFuncion(a.getFila(), a.getPosicion(), !a.isOcupado()));
            }
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return listasAsientos;
    }

    public List<AsientoSalaFuncion> getListaAsientosFuncion(int funcionId) {
        List<AsientoSalaFuncion> listasAsientos = new ArrayList<>();
        
        try {
            List<AsientoSalaFuncionBD> asientosBD = asientos.listAllByFuncion(funcionId);

            for (AsientoSalaFuncionBD a : asientosBD) {
                listasAsientos.add(new AsientoSalaFuncion(a.getFila(), a.getPosicion(), !a.isOcupado()));
            }
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return listasAsientos;
    }

    private AsientoSalaFuncionBD_DAO asientos;
}
