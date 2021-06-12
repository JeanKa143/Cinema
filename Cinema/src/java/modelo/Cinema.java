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
import java.util.List;

public class Cinema {
    private int id_cinema;
    private String nombre;
    private String direccion;
    private List<Sala> salas;
    
    public Cinema(int id_cinema, String nombre, String direccion, List<Sala> salas){
        this.id_cinema = id_cinema;
        this.nombre = nombre;
        this.direccion = direccion;
        this.salas = salas;
    }
    
    public void setIdCinema(int id_cinema){
        this.id_cinema = id_cinema;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public void setListaSalas(List<Sala> salas){
        this.salas = salas;
    }
    
    public int getIdCinema(){
        return this.id_cinema;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getDireccion(){
        return this.direccion;
    }
    
    public List<Sala> getListaSalas(){
        return this.salas;
    }
}
