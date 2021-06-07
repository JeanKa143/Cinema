/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package modelo.dao;

import db.Database;
import java.io.IOException;
import java.io.InputStream;

public class ModeloBD extends Database {

    public ModeloBD() throws IOException {
        System.out.println(this);
        InputStream in = getClass().getResourceAsStream("/modelo/dao/modelo.properties");
        loadConfiguration(in);
    }
}
