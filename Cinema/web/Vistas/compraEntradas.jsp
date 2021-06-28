<%-- 
    Document   : compraEntradas
    Created on : Jun 25, 2021, 10:56:22 PM
    Author     : diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="../CSS/login.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/default.css" rel="stylesheet" type="text/css"/>
        <title>Modulo cliente</title>
    </head>
    <body>
        <nav>
            <ul>
                <li><a onclick="cerrar()">Cerrar Sesión</li></a>
                <li><a onclick="#">Mostrar historial de compras</li></a>
            </ul>
        </nav>
        <h1>Compra exitosa!</h1>
        <h2 name="titulo" id="titulo">Estimada persona usuaria, a continuación se muestra el detalle de su compra: </h2>
        <div name="wrapper" id="wrapper">
            <p name="detalles" id="detalles"></p>
        </div>
        
       <script src="../js/cliente.js" type="text/javascript"></script>
    </body>
</html>
