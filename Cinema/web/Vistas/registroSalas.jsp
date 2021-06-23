<%-- 
    Document   : registroSalas
    Created on : 22/06/2021, 12:09:18 PM
    Author     : Luis Fallas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Salas</title>
    </head>
    <body>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link href="../CSS/registroClientes.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <form id="nuevaSala" action="#" onsubmit="return verificar('nuevaSala');">
                <h1>Registro Salas</h1>
                <table>
                    <tbody>
                        <tr>
                            <td class="etiqueta">Numero de sala&nbsp;</td>
                            <td><input name="numero" type="number" min=0 required/></td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Capacidad de la sala&nbsp;</td>
                            <td><input name="capacidad" type="number" min=0 required/></td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="2" ><button id="botonRegistro" type="submit">Registrar</button></td>
                        </tr>
                        <tr>
                            <td colspan="2" ><a href="moduloAdministrador.jsp">Regresar</a></td>
                        </tr>
                    </tfoot>
                </table>
            </form>
        </div>
    </body>
    <script src="../js/registroSalas.js" type="text/javascript"></script>        
</body>
</html>
