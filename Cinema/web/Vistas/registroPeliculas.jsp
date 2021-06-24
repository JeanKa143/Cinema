<%-- 
    Document   : registroPeliculas
    Created on : 23/06/2021, 04:00:50 PM
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
            <form id="nuevaPelicula" action="#" onsubmit="return verificar('nuevaPelicula');">
                <h1>Registro Peliculas</h1>
                <table>
                    <tbody>
                        <tr>
                            <td class="etiqueta">Titulo de la pelicula&nbsp;</td>
                            <td><input id ="titulo" name="titulo" type="text"  required/></td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Se encuentra en cartelera&nbsp;</td>
                            <td><input name="cartelera" id="enCartelera" type="radio" value ="true" required/>Si</td>
                            <td><input name="cartelera" id="sinCartelera" type="radio" value ="false" required/>No</td>
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
    <script src="../js/registroPeliculas.js" type="text/javascript"></script>        
</body>
</html>
