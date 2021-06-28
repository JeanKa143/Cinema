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
        <h1 id="titulo" name="titulo"></h1>
        <nav>
            <ul>
                <!--<li><a href="buscarFactura.jsp" style="text-decoration: none">Visualizar el historial de compras</li></a>--> 
                <li><a href="historialCompras.jsp" style="text-decoration: none">Buscar una factura</li></a> 
                <li><a onclick="cerrar()">Cerrar Sesión</li></a>
            </ul>
        </nav>
        <div id="contents">
            <h2>
                Cartelera del día
            </h2>
            <form id="formulario" action="#" onsubmit="return agregarFactura('formulario');">
                 <section>
                      <h2 id='titular' name='titular'></h2>
                      <div id="galeria" class="galeria"></div>
                  </section>
            
            
                <h2>Nombre de la pelicula:  </h2>
                <h2 name="movieName" id="movieName"></h2>
                <h1>Escoja los asientos que desea ocupar durante la función</h1>
                <p>Cantidad de butacas seleccionadas: <h2 id="butacas" name="butacas"></h2></p>
                <button name="comprar" id="comprar" type="submit">Proceder con la compra</button>
                <div id="gallery" class="gallery"> </div>
            </form>
       </div>
        </div>
        
        <script src="../js/factura.js" type="text/javascript"></script>
        <script src="../js/scriptSalas.js" type="text/javascript"></script>
        <script src="../js/cliente.js" type="text/javascript"></script>
        
    </body>
</html>
