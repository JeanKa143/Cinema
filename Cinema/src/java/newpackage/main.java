package newpackage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Funcion;
import modelo.Pelicula;
import modelo.Tiquete;
import modelo.Usuario;
import modelo.bd.AsientoSalaFuncionBD;
import modelo.bd.FuncionBD;
import modelo.conjuntos.ConjuntoFuncion;
import modelo.conjuntos.ConjuntoPelicula;
import modelo.conjuntos.ConjuntoTiquetes;
import modelo.conjuntos.ConjuntoUsuarios;
import servicios.ServicioLogin;





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
                 
     ConjuntoUsuarios c = new ConjuntoUsuarios();

     System.out.println(c.getUsuario("luis").getId());
     System.out.println(c.getUsuario("usuario1").getRol());
     System.out.println(c.getUsuario("luis").getClave());
            
            
       
    }
}
