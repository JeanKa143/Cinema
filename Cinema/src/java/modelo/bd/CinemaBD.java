/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package modelo.bd;

public class CinemaBD {
    private int id_cinema;
    private String nombre;
    private String direccion;
    
    CinemaBD(int id_cinema, String nombre, String direccion){
        this.id_cinema = id_cinema;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    /**
     * @param id_cinema the id_cinema to set
     */
    public void setIdCinema(int id_cinema){
        this.id_cinema = id_cinema;
    }
    
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    /**
     * @return the id_cinema
     */
    public int getIdCinema(){
        return this.id_cinema;
    }
    
   /**
     * @return the nombre
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * @return the direccion
     */
    public String getDireccion(){
        return this.direccion;
    }
}
