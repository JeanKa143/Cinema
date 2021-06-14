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

import modelo.Cliente;

public class ClienteBD {
    private String usuario_id_usuario;
    private String id_cliente;
    private String apellidos;
    private String nombre;
    private String telefono;
    private String tarjeta_pago;
    
    public ClienteBD(String usuario_id_usuario, String id_cliente, String apellidos, String nombre, String telefono,
            String tarjeta_pago){
        this.usuario_id_usuario = usuario_id_usuario;
        this.id_cliente = id_cliente;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tarjeta_pago = tarjeta_pago;
    }

     public ClienteBD(Cliente cliente) {
        this(
              cliente.getId(),
              cliente.getId(),
              cliente.getApellidos(),
              cliente.getNombre(),
              cliente.getTelefono(),
              cliente.getTarjetaPago()
              );
    }
    /**
     * @param usuario_id_usuario the usuario_id_usuario to set
     */
    public void setUsuario_id_usuario(String usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }

    
    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @param tarjeta_pago the tarjeta_pago to set
     */
    public void setTarjeta_pago(String tarjeta_pago) {
        this.tarjeta_pago = tarjeta_pago;
    }

     /**
     * @return the id_cliente
     */
    public String getId_cliente() {
        return id_cliente;
    }
    
     /**
     * @return the usuario_id_usuario
     */
    public String getUsuarioIdUsuario() {
        return usuario_id_usuario;
    }

     /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

     /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

     /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

     /**
     * @return the nomtarjeta_pagobre
     */
    public String getTarjeta_pago() {
        return tarjeta_pago;
    }
    
    
}
