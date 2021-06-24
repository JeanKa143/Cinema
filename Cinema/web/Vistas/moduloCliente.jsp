<%-- 
    Document   : moduloCliente
    Created on : Jun 17, 2021, 3:09:26 AM
    Author     : diana
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../CSS/default.css" rel="stylesheet" type="text/css"/>
        <title>Modulo cliente</title>
    </head>
    <body>
        <h1 id="titulo" name="titulo">Bienvenido, </h1>
        <nav>
            <ul>
                <li><a onclick="cerrar()">Cerrar Sesión</li></a>
                <!--<li><a onclick="butacas()">Seleccionar butacas</li></a>-->
            </ul>
        </nav>
        <div id="contents">
            <h2>
                Cartelera del día
            </h2>
      
            <section>
                <h2 id='titular' name='titular'></h2>
                <div id="galeria" class="galeria"></div>
            </section>
        </div>
       
        <script src="../js/cartelera.js" type="text/javascript"></script>
        <script src="../js/cliente.js" type="text/javascript"></script>
    </body>
</html>
