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

public class UsuarioBD {
    private String id_usuario;
    private String clave;
    private int rol;
    
    UsuarioBD(String id_usuario, String clave, int rol){
        this.id_usuario = id_usuario;
        this.clave = clave;
        this.rol = rol;
    }
    
    /**
     * @param id_usuario the id_usuario to set
     */
    public void setIdUsuario(String id_usuario){
        this.id_usuario  = id_usuario;
    }
    
    /**
     * @param clave the clave to set
     */
    public void setClave(String clave){
        this.clave = clave;
    }
    
    /**
     * @param rol the rol to set
     */
    public void setRol(int rol){
        this.rol = rol;
    }
    
     /**
     * @return the id_usuario
     */
    public String getIdUsuario(){
        return this.id_usuario;
    }
    
     /**
     * @return the clave
     */
    public String getClave(){
        return this.clave;
    }
    
     /**
     * @return the rol
     */
    public int getRol(){
        return this.rol;
    }
}
