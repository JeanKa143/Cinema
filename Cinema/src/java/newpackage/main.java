package newpackage;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.bd.FuncionBD;
import modelo.dao.FuncionBD_DAO;

/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
/**
 *
 * @author Luis Fallas
 */
public class main {

    public static void main(String args[]) {
        try {
            FuncionBD f = new FuncionBD(0, new Date(), 1, 20, "337404");
            FuncionBD_DAO fDB = new FuncionBD_DAO();
            fDB.add(f);
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
}
