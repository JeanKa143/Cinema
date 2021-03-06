<%-- 
    Document   : historialCompras
    Created on : Jun 25, 2021, 11:02:00 PM
    Author     : diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link href="../CSS/registroClientes.css" rel="stylesheet" type="text/css"/>
        <script src="../js/historialCompra.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
    </head>
    <body>
         <nav>
            <ul>
                <li><a onclick="generaPDF()" style="text-decoration: none">Generar pdf de la compra</li></a>   
            </ul>
        </nav>
        <div id="wrapper">
            <form id="compra" action="#" onsubmit="return cargarFactura('compra');">
                <h1>Busqueda de compras</h1>
                <table>
                    <tbody>
                        <tr>
                            <td class="etiqueta">ID de la factura:&nbsp;</td>
                            <td><input id = "id" name="id"required/></td>
                    
                        </tr>
                        
                    <tfoot>
                        <tr>
                            <td colspan="2" ><button id="botonBuscar" type="submit">Buscar</button></td>
                            
                        </tr>
                        <tr>
                            <td colspan="2" ><a href="moduloCliente.jsp" style="text-decoration: none">Regresar</a></td>
                        </tr>
                    </tfoot>
                </table>
                <h1 name="factura" id="factura"></h1>
              
            </form>
        </div>
    </body>
    
</html>
