<%-- 
    Document   : moduloCliente
    Created on : Jun 17, 2021, 3:09:26 AM
    Author     : diana
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../CSS/default.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/sala.css" rel="stylesheet" type="text/css"/>
        <title>Modulo cliente</title>
    </head>
    <body>
        <h1 id="titulo" name="titulo">Bienvenido, </h1>
        <nav>
            <ul>
                <li><a onclick="cerrar()">Cerrar Sesi�n</li></a>
                <!--<li><a onclick="butacas()">Seleccionar butacas</li></a>-->
            </ul>
        </nav>
        <div id="contents">
            <h2>
                Cartelera del d�a
            </h2>
            
            <section>
                    <h2 id='titular' name='titular'></h2>
                    <div id="galeria" class="galeria"></div>
            </section>
            <--!<!-- PORFA AYUDENME A HACER ESTO UN POP-UP -->
            <h2>Nombre de la pelicula:  </h2>
            <h2 name="movieName" id="movieName"></h2>
            <h1>Escoja los asientos que desea ocupar durante la funci�n</h1>
            <div id="gallery" class="gallery"> </div>
            <p>Cantidad de butacas seleccionadas: </p>
            <h2 id="butacas" name="butacas"></h2>
       </div>
        </div>
        
        <script src="../js/scriptSalas.js" type="text/javascript"></script>
        <script src="../js/cartelera.js" type="text/javascript"></script>
        <script src="../js/busqueda.js" type="text/javascript"></script>
        <script src="../js/cliente.js" type="text/javascript"></script>
    </body>
</html>
