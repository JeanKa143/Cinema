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
        <div>
            <nav>
                <ul>
                    <li><a href="#">Inicio</a></li>
                    <li><a href="#">Contactenos</a></li>
                    <li><a href="registroClientes.jsp">Registro</a></li>
                    <li><a href="#">Iniciar sesion</a></li>
                    <li><a href="#">Asientos</a></li>
                </ul>
            </nav>
        </div>
        <div id="contents">

            <section>
                <table id="galeria" class="galeria">
            </section>
            <div id="modal_contenedor" class="modal-contenedor">
                <div id="mod" class="moda">
                    <h3 id="titulo">
                        
                    </h3>
                    <h3 id="id">
                        
                    </h3>
                    <h3 id="sinopsis">
                        
                    </h3>
                    <button id="cerrar-btn">
                        Cerrar
                    </button>
                    
                    <img id="pop-up-img">
                    
                </div>

            </div>
        </div>

        <footer>

        </footer>
    </body>
    <script src="../js/busqueda.js" type="text/javascript"></script>
</html>
