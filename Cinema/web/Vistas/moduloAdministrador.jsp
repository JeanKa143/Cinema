<%-- 
    Document   : moduloAdministrador
    Created on : Jun 17, 2021, 3:09:51 AM
    Author     : diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../CSS/default.css" rel="stylesheet" type="text/css"/>
        <title>Administrador</title>
    </head>
    <body>
        <h1>Modulo administrador</h1>
        <nav>
            <ul>
                <li><a href="registroPeliculas.jsp">Registrar nuevas peliculas</a></li>
                <li><a href="registroSalas.jsp">Registrar nuevas salas</a></li>
                <li><a href="actualizarCartelera.jsp">Actualizar la cartelera</a></li>
                <li><a href="#">Programar proyecciones</a></li>
                <li><a href="#">Buscar tiquetes</a></li>
                <li><a href="index.jsp">Volver al menu principal</a></li>
                <li><a onclick="cerrar()">Cerrar Sesión</li>
            </ul>
        </nav>
        <div id="contents">
            <h2>
                Peliculas registradas
            </h2>
            <section>
                <table id="galeria" class="galeria">
            </section>
            <div id="modal_contenedor" class="modal-contenedor">


                <button id="cerrar-btn">
                    Cerrar
                </button>
            </div>
        </div>
    </body>
    <script src="../js/administrador.js" type="text/javascript"></script>
</html>
