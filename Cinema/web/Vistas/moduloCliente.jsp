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
                <li><a href="index.jsp">Volver al menu principal</a></li>
                <li><a onclick="cerrar()">Cerrar Sesión</li>
            </ul>
        </nav>
        <div id="contents">
            <h2>
                Cartelera del día
            </h2>
            <section>
                <table id="galeria" class="galeria">
                   
            </section>
        </div>
       
        <script src="../js/cartelera.js" type="text/javascript"></script>
        <script src="../js/cliente.js" type="text/javascript"></script>
    </body>
</html>
