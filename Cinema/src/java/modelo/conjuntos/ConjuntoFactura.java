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
import java.util.List;
import modelo.bd.FacturaBD;
import modelo.dao.FacturaBD_DAO;

public class ConjuntoFactura {

    public ConjuntoFactura() {
        try {
            this.facturas = new FacturaBD_DAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void agregarFactura(FacturaBD factura) {
        try {
            facturas.add(factura.getSeq_factura(), factura);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public FacturaBD getFactura(int facturaId) {
        try {
            FacturaBD facturaBD = facturas.retrieve(facturaId);

            if (facturaBD != null) {
                return facturaBD;
            }
        } catch (IOException | IllegalArgumentException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return null;
    }

    public List<FacturaBD> getListaFacturas() {

        try {
            List<FacturaBD> facturasBD = facturas.listAll();
            if(facturasBD != null){
                return facturasBD;
            }
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return null;
    }

   
    public List<FacturaBD> getListaFacturasCliente(String clienteId) {

        try {
            List<FacturaBD> facturasBD = facturas.listAllByCliente(clienteId);
            if(facturasBD != null){
                return facturasBD;
            }
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return null;
    }

    private FacturaBD_DAO facturas;
    //private ConjuntoCliente clientes;
}
