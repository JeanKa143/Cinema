package newpackage;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.Factura;
import modelo.bd.FacturaBD;
import modelo.bd.FuncionBD;
import modelo.conjuntos.ConjuntoClientes;
import modelo.conjuntos.ConjuntoFactura;
import modelo.dao.FuncionBD_DAO;

/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
/**
 *
 * @author Luis Fallas
 */
public class main {

    public static void main(String args[]) {
        try {
            //t seq_factura, String fecha, String tarjeta_pago, String cliente_id, String cliente_usuario_id
            ConjuntoClientes c = new ConjuntoClientes();
            Cliente cl = c.getCliente("402500956");
            Date date = new Date();
            FacturaBD f = new FacturaBD(1, date, cl.getTarjeta_pago(), cl.getIdCliente(), cl.getId());
            ConjuntoFactura fe = new ConjuntoFactura();
            fe.agregarFactura(f);
           // System.out.println(fe.getFactura(5).getCliente_id());
            
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
}
