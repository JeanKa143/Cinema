<%-- 
    Document   : actualizarCartelera
    Created on : 26 jun. 2021, 08:33:48
    Author     : JeanKa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar cartelera</title>
        <link href="../CSS/actualizarCartelera.css" rel="stylesheet" type="text/css"/>
        <script src="../js/actualizarCartelera.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <h1>Cartelera</h1>
            <form id="formulario" action="#" onsubmit="return false;">
                <section id="busqueda">
                    <p>Buscar pelicula:</p>
                    <input id="pelicula" placeholder="Titulo"/>
                    <button onclick="mostrarPelicula();">Buscar</button>
                </section>
                <section class="oculto">
                    <img id="poster">
                    <p id="titulo"></p>
                </section>
                <section class="oculto">
                    <button id="btnQuitar"class="boton" value="0" type="submit" onclick="quitar();" >Quitar de cartelera</button>
                    <button id="btnAgragar" class="boton" value="1" type="submit" onclick="agregar();">Agregar a cartelera</button>
                </section>
            </form>
            <a href="moduloAdministrador.jsp">volver</a>
        </div>
    </body>
</html>
