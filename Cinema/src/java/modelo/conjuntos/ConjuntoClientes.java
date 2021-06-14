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
import modelo.Cliente;
import modelo.bd.ClienteBD;
import modelo.dao.ClienteBD_DAO;

/**
 *
 * @author diana
 */
public class ConjuntoClientes {
      public ConjuntoClientes() {
        try {
            clientes = new ClienteBD_DAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void agregarCliente(Cliente cliente) {
        try {
            clientes.add(Integer.parseInt(cliente.getId()), new ClienteBD(cliente));
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public Cliente getCliente(String cliente_id) {
        Cliente cliente = null;

        try {
            ClienteBD clienteBD = clientes.retrieve(Integer.parseInt(cliente_id));

            if (clienteBD != null) {
                cliente = new Cliente(clienteBD.getId_cliente(), null, null, clienteBD.getNombre(), clienteBD.getApellidos(),
                clienteBD.getTelefono(), clienteBD.getTarjeta_pago(), null);
                /*
                Para insertar facturas y datos del usuario, es necesario realizar una consulta
                a la tabla de usuarios y a la tabla de facturas basandose en el id del cliente*/
            }
        } catch (IOException | IllegalArgumentException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return cliente;
    }

    public List<Cliente> getListaCientes() {
        List<Cliente> listaClientes = new ArrayList<>();

        try {
            List<ClienteBD> clientesBD = clientes.listAll();

            for (ClienteBD p : clientesBD) {
               
                listaClientes.add(new Cliente(p.getId_cliente(), null, null, p.getNombre(), p.getApellidos(),
                p.getTelefono(), p.getTarjeta_pago(), null));
                /*
                Para insertar facturas y datos del usuario, es necesario realizar una consulta
                a la tabla de usuarios y a la tabla de facturas basandose en el id del cliente*/
            }
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return listaClientes;
    }

    private ClienteBD_DAO clientes;
}
