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
            int funcionSalaNumero) throws SQLException, IOException {

        asientos.add(0, new AsientoSalaFuncionBD(asiento, funcionId, funcionFecha, funcionSalaCine, funcionSalaNumero));
    }

    public AsientoSalaFuncion getAsiento(char fila, int posicion, int funcionId) throws SQLException, IOException {
        AsientoSalaFuncionBD asientoBD = asientos.retrieve(fila, posicion, funcionId);

        if (asientoBD != null) {
            return new AsientoSalaFuncion(asientoBD.getFila(), asientoBD.getPosicion(), !asientoBD.isOcupado());
        }

        return null;
    }

    public List<AsientoSalaFuncion> getListaAsientos() throws SQLException, IOException {
        List<AsientoSalaFuncionBD> asientosBD = asientos.listAll();
        List<AsientoSalaFuncion> listasAsientos = new ArrayList<>();

        for (AsientoSalaFuncionBD a : asientosBD) {
            listasAsientos.add(new AsientoSalaFuncion(a.getFila(), a.getPosicion(), !a.isOcupado()));
        }

        return listasAsientos;
    }

    public List<AsientoSalaFuncion> getListaAsientosFuncion(int funcionId) throws SQLException, IOException {
        List<AsientoSalaFuncionBD> asientosBD = asientos.listAllByFuncion(funcionId);
        List<AsientoSalaFuncion> listasAsientos = new ArrayList<>();

        for (AsientoSalaFuncionBD a : asientosBD) {
            listasAsientos.add(new AsientoSalaFuncion(a.getFila(), a.getPosicion(), !a.isOcupado()));
        }

        return listasAsientos;
    }

    private AsientoSalaFuncionBD_DAO asientos;
}
