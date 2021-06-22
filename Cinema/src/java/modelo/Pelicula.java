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

import java.io.Serializable;
import org.json.JSONObject;

public class Pelicula implements Serializable {

    public Pelicula(String id_pelicula, String titulo, String poster_path, String movie_data, Boolean cartelera) {
        this.id_pelicula = id_pelicula;
        this.titulo = titulo;
        this.poster_path = poster_path;
        this.movie_data = movie_data;
        this.cartelera = cartelera;
    }

    public Pelicula(JSONObject j) {
        this(j.getString("id_pelicula"), j.getString("titulo"), j.getString("poster_path"), j.getString("movie_data"),
                j.getBoolean("cartelera"));
    }

    public Pelicula() {
        this(null, null, null, null, false);
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();

        r.put("id_pelicula", id_pelicula);
        r.put("titulo", titulo);
        r.put("poster_path", poster_path);
        r.put("movie_data", movie_data);
        r.put("cartelera", cartelera);

        return r;
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

    public Boolean getCartelera() {
        return this.cartelera;
    }

    public void setCartelera(Boolean cartelera) {
        this.cartelera = cartelera;
    }

    private String id_pelicula;
    private String titulo;
    private String poster_path;
    private String movie_data;
    private Boolean cartelera;

}
