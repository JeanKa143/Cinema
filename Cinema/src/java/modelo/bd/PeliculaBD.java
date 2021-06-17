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

import java.io.Serializable;
import modelo.Pelicula;

public class PeliculaBD implements Serializable {

    public PeliculaBD(String id_pelicula, String titulo, String poster_path, String movie_data, int cartelera) {
        this.id_pelicula = id_pelicula;
        this.titulo = titulo;
        this.poster_path = poster_path;
        this.movie_data = movie_data;
        this.cartelera=cartelera;
    }

    public PeliculaBD(Pelicula pelicula) {
        this(
                pelicula.getId_pelicula(),
                pelicula.getTitulo(),
                pelicula.getPoster_path(),
                pelicula.getMovie_data(),0
        );
        if(pelicula.getCartelera().equals(true)){
            setCartelera(1);
        }
    }

    public PeliculaBD() {
        this(null, null, null, null,0);
    }

    public String getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(String id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getMovie_data() {
        return movie_data;
    }

    public void setMovie_data(String movie_data) {
        this.movie_data = movie_data;
    }

     public int getCartelera() {
        return cartelera;
    }

    public void setCartelera(int cartelera) {
        this.cartelera = cartelera;
    }
    
    private String id_pelicula;
    private String titulo;
    private String poster_path;
    private String movie_data;
    private int cartelera;

    
   
}
