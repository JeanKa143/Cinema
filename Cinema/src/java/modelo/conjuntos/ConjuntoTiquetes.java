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
import modelo.Tiquete;
import modelo.bd.AsientoSalaFuncionBD;
import modelo.bd.TiqueteBD;
import modelo.dao.TiqueteBD_DAO;

/**
 *
 * @author Luis Fallas
 */
public class ConjuntoTiquetes implements Serializable {

    private TiqueteBD_DAO tiquetes;

    public ConjuntoTiquetes() {
        this.tiquetes = null;

        try {
            this.tiquetes = new TiqueteBD_DAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    //agrega a la base de datos
    public void agregar(TiqueteBD tiqueteNuevo) throws SQLException, IOException {
        tiquetes.add(tiqueteNuevo.getId_tiquete(), tiqueteNuevo);
    }

    //saca de la base el tiquete con el ID solicitado
    public Tiquete obtener(int id) {
        try {
            //  int funcion_sala_cinema, int funcion_sala_numero
            TiqueteBD tiquete = tiquetes.retrieve(id);
            AsientoSalaFuncionBD asiento = new AsientoSalaFuncionBD(
                    tiquete.getAsiento_funcion_fila(),
                    tiquete.getAsiento_funcion_posicion(),
                    tiquete.getAsiento_funcion_funcion_id(),
                    tiquete.getAsiento_funcion_funcion_fecha(),
                    tiquete.getAsiento_funcion_funcion_sala_cinema_id(),
                    tiquete.getAsiento_funcion_funcion_sala_numero());

            Tiquete t = new Tiquete(tiquete.getId_tiquete(), asiento, tiquete.getMonto());
            return t;

        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return null;
        }
    }
    //enlista los tiquetes de la BD

    public List<Tiquete> getListaTiquetes() {
        List<TiqueteBD> listaTiquetesBD = new ArrayList<>();
        List<Tiquete> listaTiquetes = new ArrayList<>();
        try {
            listaTiquetesBD = tiquetes.listAll();
            for (int i = 0; i < listaTiquetesBD.size(); i++) {
                AsientoSalaFuncionBD asiento = new AsientoSalaFuncionBD(
                        listaTiquetesBD.get(i).getAsiento_funcion_fila(),
                        listaTiquetesBD.get(i).getAsiento_funcion_posicion(),
                        listaTiquetesBD.get(i).getAsiento_funcion_funcion_id(),
                        listaTiquetesBD.get(i).getAsiento_funcion_funcion_fecha(),
                        listaTiquetesBD.get(i).getAsiento_funcion_funcion_sala_cinema_id(),
                        listaTiquetesBD.get(i).getAsiento_funcion_funcion_sala_numero());
                Tiquete t = new Tiquete(listaTiquetesBD.get(i).getId_tiquete(), asiento, listaTiquetesBD.get(i).getMonto());
                listaTiquetes.add(t);
            }
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return listaTiquetes;
    }

    //borra el tique que tiene el ID de la BD
    public void borrarTiquete(int id) {

        try {
            tiquetes.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //actualiza el tiquete en la BD
    
    public void actualizar(TiqueteBD value){
        try {
            tiquetes.update(value.getId_tiquete(), value);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
