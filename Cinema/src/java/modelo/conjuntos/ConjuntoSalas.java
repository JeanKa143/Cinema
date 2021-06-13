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
import modelo.Sala;
import modelo.bd.SalaBD;
import modelo.dao.SalaBD_DAO;

/**
 *
 * @author Luis Fallas
 */
public class ConjuntoSalas implements Serializable {

    private SalaBD_DAO salas;

    public ConjuntoSalas() {
        this.salas = null;
        try {
            this.salas = new SalaBD_DAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    //agrega a la base de datos
     public void agregar(SalaBD nuevaSala) throws SQLException, IOException {
         salas.add(nuevaSala.getNumero(), nuevaSala);
     }
    
    //saca de la base la sala con el ID solicitado
    public Sala obtener(int id) { 
        try {
            SalaBD sala = salas.retrieve(id);
            Sala aux = new Sala(sala.getNumero(),sala.getCapacidad());
            return aux;

        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return null;
        }
    }
    //enlista las salas de la BD
     public List<Sala> getListaSalas() {
         List<Sala> listaSalas = new ArrayList<>();
         List<SalaBD> listaSalasBD = new ArrayList<>();
        try {
            listaSalasBD = salas.listAll();
            for(int i=0; i<listaSalasBD.size(); i++){
                Sala s = new Sala (listaSalasBD.get(i).getNumero(),listaSalasBD.get(i).getCapacidad());
                listaSalas.add(s);
            }
                
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
              return listaSalas;
    }
    
     //borra una sala de la BD
     public void borrarSala(int id){
        try {
            salas.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoSalas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoSalas.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
     //actualiza la sala en la BD
     public void actualizar(SalaBD value){
        try {
            salas.update(value.getCinema_id(), value);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoSalas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoSalas.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
