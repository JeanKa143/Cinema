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
import modelo.Factura;
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

    public void agragarFactura(Factura factura) {
        try {
            facturas.add(0, new FacturaBD(factura));
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    //Falta completar
    public Factura getFactura(int facturaId) {
        Factura factura = null;

        try {
            FacturaBD facturaBD = facturas.retrieve(facturaId);

            if (facturaBD != null) {
                factura = new Factura(facturaBD.getSeq_factura(), facturaBD.getFecha(), /*obtener cliente de ConjuntoCliente*/ null);
            }
        } catch (IOException | IllegalArgumentException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return factura;
    }

    //Falta completar
    public List<Factura> getListaFacturas() {
        List<Factura> listaFacturas = new ArrayList<>();

        try {
            List<FacturaBD> facturasBD = facturas.listAll();

            for (FacturaBD f : facturasBD) {
                listaFacturas.add(new Factura(f.getSeq_factura(), f.getFecha(), /*obtener cliente de ConjuntoCliente*/ null));
            }
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return listaFacturas;
    }

    //Falta completar
    public List<Factura> getListaFacturasCliente(String clienteId) {
        List<Factura> listaFacturas = new ArrayList<>();

        try {
            List<FacturaBD> facturasBD = facturas.listAllByCliente(clienteId);

            for (FacturaBD f : facturasBD) {
                listaFacturas.add(new Factura(f.getSeq_factura(), f.getFecha(), /*obtener cliente de ConjuntoCliente*/ null));
            }
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return listaFacturas;
    }

    private FacturaBD_DAO facturas;
    //private ConjuntoCliente clientes;
}
