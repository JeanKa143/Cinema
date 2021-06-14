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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import modelo.Usuario.Rol;
import modelo.bd.UsuarioBD;
import modelo.dao.UsuarioBD_DAO;

/**
 *
 * @author diana
 */
public class ConjuntoUsuarios {
      public ConjuntoUsuarios() {
        try {
            usuarios = new UsuarioBD_DAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void agregarUsuario(Usuario usuario) {
        try {
            usuarios.add(Integer.parseInt(usuario.getId()), new UsuarioBD(usuario));
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public Usuario getUsuario(String usuario_id) {
        Usuario usuario = null;

        try {
            UsuarioBD usuarioBD = usuarios.retrieve(Integer.parseInt(usuario_id));

            if (usuarioBD != null) {
                Rol rol = null;
                if(usuarioBD.getRol() == 1){ rol = Rol.administrador;}
                else if (usuarioBD.getRol() == 2) { rol = Rol.cliente;}
                usuario = new Usuario(usuarioBD.getIdUsuario(), usuarioBD.getClave(), rol);
            }
        } catch (IOException | IllegalArgumentException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return usuario;
    }

    public List<Usuario> getListaPeliculas() {
        List<Usuario> listaUsuarios = new ArrayList<>();

        try {
            List<UsuarioBD> usuariosBD = usuarios.listAll();

            for (UsuarioBD p : usuariosBD) {
                
                Rol rol = null;
                if(p.getRol() == 1){
                    rol = Rol.administrador;
                }
                else if (p.getRol() == 2){
                    rol = Rol.cliente;
                }
                listaUsuarios.add(new Usuario(p.getIdUsuario(), p.getClave(), rol));
            }
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return listaUsuarios;
    }

    private UsuarioBD_DAO usuarios;
}
