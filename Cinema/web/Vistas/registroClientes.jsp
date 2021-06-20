<%-- 
    Document   : registroClientes
    Created on : 16 jun. 2021, 15:51:25
    Author     : JeanKa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link href="../CSS/registroClientes.css" rel="stylesheet" type="text/css"/>
        <script src="../js/registroCliente.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <form id="nuevoCliente" action="#" onsubmit="return verificar('nuevoCliente');">
                <h1>Registro Cliente</h1>
                <table>
                    <tbody>
                        <tr>
                            <td class="etiqueta">Nombre de usuario:&nbsp;</td>
                            <td><input name="id" required/></td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Contraseña:&nbsp;</td>
                            <td><input name="clave" type="password" required/></td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Nombre:&nbsp;</td>
                            <td><input name="nombre" required/></td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Apellidos:&nbsp;</td>
                            <td><input name="apellidos" required /></td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Identificación&nbsp;</td>
                            <td><input class="inputNoSpin" name="idCliente" type="number" required /></td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Teléfono:&nbsp;</td>
                            <td><input class="inputNoSpin" name="telefono" type="number" required /></td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Tarjeta de pago:&nbsp;</td>
                            <td><input class="inputNoSpin" name="tarjeta_pago" type="number" required/></td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="2" ><button id="botonRegistro" type="submit">Registrarse</button></td>
                        </tr>
                        <tr>
                            <td colspan="2" ><a href="index.jsp">Regresar</a></td>
                        </tr>
                    </tfoot>
                </table>
            </form>
        </div>
    </body>
</html>
