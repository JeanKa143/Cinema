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

import modelo.Usuario;
import modelo.Usuario.Rol;


public class UsuarioBD {
    private String id_usuario;
    private String clave;
    private int rol;

    public UsuarioBD() {
        this.id_usuario="";
        this.clave="";
        this.rol=0;
    }
    
    public UsuarioBD(String id_usuario, String clave, int rol){
        this.id_usuario = id_usuario;
        this.clave = clave;
        this.rol = rol;
    }
    
      public UsuarioBD(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getClave(),
                updateRol(usuario)
        );
    }
      
      static int updateRol(Usuario usuario){
            int r_ol = 2; //inserta rol de cliente por defecto
            if(usuario.getRol() == Rol.administrador ){ r_ol = 1; }
            else if(usuario.getRol() == Rol.cliente ){ r_ol = 2; }
            return r_ol;
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
