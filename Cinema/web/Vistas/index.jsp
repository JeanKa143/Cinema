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
                <input type="text" placea holder="Nombre Pelicula" id="busqueda">
                <button id="btn-buscar" type="button" class="btn-busca">Buscar</button>
            </div>
        </header>
        <div>
            <nav>
                <ul>
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="#">Contactenos</a></li>
                    <li><a href="registroClientes.jsp">Registro</a></li>
                    <li><a href="login.jsp">Iniciar sesion</a></li>
                    <li><a href="#">Asientos</a></li>
                </ul>
            </nav>
        </div>
        <div id="contents">

            <section>
                <table id="galeria" class="galeria">
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
    <script src="../js/busqueda.js" type="text/javascript"></script>
</html>
