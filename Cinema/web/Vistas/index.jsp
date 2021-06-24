<%-- 
    Document   : index
    Created on : 17/06/2021, 03:23:34 PM
    Author     : Luis Fallas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cinema</title>
        <meta charset="UTF-8" />
        <link href="../CSS/default.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>   
        <header>
            <div class="buscar">
                <input type="text" placea holder="Nombre Pelicula" id="busqueda">
                <button id="btn-buscar" type="button" class="btn-busca">Buscar</button>
            </div>
        </header>
        <div>
            <nav>
                <ul>
                    <li><a href="index.jsp" style="text-decoration: none">Inicio</a></li>
                    <li><a href="#" style="text-decoration: none">Contactenos</a></li>
                    <li><a href="registroClientes.jsp" style="text-decoration: none">Registro</a></li>
                    <li><a onclick="login()">Iniciar sesion</a></li>
                    <li><a href="#" style="text-decoration: none">Asientos</a></li>
                </ul>
            </nav>
        </div>
        <div id="contents">
            <h2>
                Cartelera
            </h2>
           <section>
                <h2 id='titular' name='titular'></h2>
                <div id="galeria" class="galeria"></div>
            </section>
            <div id="modal_contenedor" class="modal-contenedor">
                <button id="cerrar-btn">
                    Cerrar
                </button>
            </div>
        </div>
        <footer>
        </footer>
    </body>
    <script src="../js/cartelera.js" type="text/javascript"></script>
    <script src="../js/busqueda.js" type="text/javascript"></script>
</html>
