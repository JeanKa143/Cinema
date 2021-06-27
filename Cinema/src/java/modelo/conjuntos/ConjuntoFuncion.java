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
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Funcion;
import modelo.bd.FuncionBD;
import modelo.dao.FuncionBD_DAO;

/**
 *
 * @author Luis Fallas
 */
public class ConjuntoFuncion implements Serializable {

    private FuncionBD_DAO funcion;

    public ConjuntoFuncion() {
        this.funcion = null;
        try {
            this.funcion = new FuncionBD_DAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    //agrega a la base de datos
    public void agregar(FuncionBD nuevaFuncion) throws SQLException, IOException {
        funcion.add(nuevaFuncion.getId_funcion(), nuevaFuncion);
    }
    
    public int agregar2(FuncionBD nuevaFuncion) throws SQLException, IOException{
        return funcion.add(nuevaFuncion);
    }

    //saca de la base la sala con el ID solicitado
    public Funcion obtener(int id) {
        try {
            FuncionBD fun = funcion.retrieve(id);
            Funcion aux = new Funcion(fun.getFecha(), fun.getPelicula_id());
            return aux;

        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return null;
        }
    }

    //enlista las funciones de la BD
    public List<Funcion> getListaFunciones() {
        List<Funcion> listaFunciones = new ArrayList<>();
        List<FuncionBD> listaFuncionesBD = new ArrayList<>();
        try {
            listaFuncionesBD = funcion.listAll();
            for (int i = 0; i < listaFuncionesBD.size(); i++) {
                Funcion f = new Funcion(listaFuncionesBD.get(i).getFecha(), listaFuncionesBD.get(i).getPelicula_id());
                listaFunciones.add(f);
            }

        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return listaFunciones;
    }

    //borra una sala de la BD
    public void borrarSala(int id) {
        try {
            funcion.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoSalas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoSalas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //actualiza la funcion en la BD
    public void actualizar(FuncionBD value) {
        try {
            funcion.update(value.getId_funcion(), value);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoFuncion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoFuncion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
