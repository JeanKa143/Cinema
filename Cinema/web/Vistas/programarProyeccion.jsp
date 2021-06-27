<%-- 
    Document   : programarProyeccion
    Created on : 26 jun. 2021, 16:24:46
    Author     : JeanKa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Programar proyeccion</title>
        <link href="../CSS/programarProyeccion.css" rel="stylesheet" type="text/css"/>
        <script src="../js/actualizarCartelera.js" type="text/javascript"></script>
        <script src="../js/proyecciones.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <h1>Cartelera</h1>
            <form id="formulario" action="#" onsubmit="return crearProyeccion('formulario');">
                <section id="busqueda">
                    <p>Buscar pelicula:</p>
                    <input id="pelicula" placeholder="Titulo"/>
                    <button type="button" onclick="mostrarPelicula();">Buscar</button>
                </section>
                <section class="oculto">
                    <img id="poster">
                    <p id="titulo"></p>
                </section>
                <section class="oculto">
                    <label for="salas">Número de sala:</label>
                    <select id="salas" size="1">
                    </select>
                </section>
                <section class="oculto">
                    <label for="fecha">Fecha:</label>
                    <input id="fecha" type="date" required/>
                    <br />
                    <label for="hora">Hora (Formato 24h):</label>
                    <input id="hora" placeholder="00:00"/>
                </section>
                <section class="oculto">
                    <button>Aplicar</button>
                </section>
            </form>
            <a href="moduloAdministrador.jsp">volver</a>
        </div>
    </body>
</html>
