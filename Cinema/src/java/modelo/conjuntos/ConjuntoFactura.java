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

    public void agragarFactura(Factura factura) throws SQLException, IOException {
        facturas.add(0, new FacturaBD(factura));
    }

    //Falta completar
    public Factura getFactura(int facturaId) throws SQLException, IOException {
        FacturaBD facturaBD = facturas.retrieve(facturaId);

        if (facturaBD != null) {
            return new Factura(facturaBD.getSeq_factura(), facturaBD.getFecha(), /*obtener cliente de ConjuntoCliente*/ null);
        }

        return null;
    }

    //Falta completar
    public List<Factura> getListaFacturas() throws SQLException, IOException {
        List<FacturaBD> facturasBD = facturas.listAll();
        List<Factura> listaFacturas = new ArrayList<>();

        for (FacturaBD f : facturasBD) {
            listaFacturas.add(new Factura(f.getSeq_factura(), f.getFecha(), /*obtener cliente de ConjuntoCliente*/ null));
        }

        return listaFacturas;
    }

    //Falta completar
    public List<Factura> getListaFacturasCliente(String clienteId) throws SQLException, IOException {
        List<FacturaBD> facturasBD = facturas.listAllByCliente(clienteId);
        List<Factura> listaFacturas = new ArrayList<>();

        for (FacturaBD f : facturasBD) {
            listaFacturas.add(new Factura(f.getSeq_factura(), f.getFecha(), /*obtener cliente de ConjuntoCliente*/ null));
        }

        return listaFacturas;
    }

    private FacturaBD_DAO facturas;
    //private ConjuntoCliente clientes;
}
