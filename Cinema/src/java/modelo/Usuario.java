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

public class Usuario implements Serializable {

    private String id;
    private String clave;
 

    public enum Rol implements Serializable {
        administrador,
        cliente
    }

    private Rol rol;

    public Usuario() {
        this.id = "";
        this.clave = "";
        this.rol = Rol.cliente;
    }

    public Usuario(String id, String clave, Rol rol) {
        this.id = id;
        this.clave = clave;
        this.rol = rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rol getRol() {
        return this.rol;
    }

    public String getId() {
        return this.id;
    }

    public String getClave() {
        return this.clave;
    }

}
