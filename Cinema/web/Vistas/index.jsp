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
        <script src="../js/cartelera.js" type="text/javascript"></script>
        
    </head>
    <body>   
        <header>
            <div class="buscar">
                <input type="text" placeholder="Nombre Pelicula" id="busqueda">
                <button id="btn-buscar" type="button" class="btn-busca">Buscar</button>
            </div>
        </header>

        <nav>
            <ul>
                <li><a href="#">Inicio</li>
                <li><a href="#">Contactenos</li>
                <li><a href="#">Registro</li>
                <li><a href="#">Iniciar sesion</li>
                <li><a href="eleccionAsientoSala.jsp">Asientos</li>
            </ul>
        </nav>
        <div id="contents">
            <section>
                <table id="galeria" class="galeria">
            </section>
            <div id="search">
                
            </div>
        </div>
      
        <footer></footer>
    </div>

</body>
<script src="../js/busqueda.js" type="text/javascript"></script>
</html>
