<%-- 
    Document   : busquedaTiquetes
    Created on : 27 jun. 2021, 20:55:04
    Author     : JeanKa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda Tiquetes</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
        <script src="../js/tiquete.js" type="text/javascript"></script>
        <link href="../CSS/busquedaTiquetes.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <h1>Tiquetes</h1>
            <form id="formulario" action="#" onsubmit="return buscarTiquete('formulario');">
                <section id="busqueda">
                    <p>Buscar tiquete</p>
                    <input class="inputNoSpin" id="idTiquete" type="number" placeholder="ID Tiquete" required/>
                    <button type="submit">Buscar</button>
                </section>
            </form>
            <section id="infoTiquete" class="oculto">
            </section>
            <button class="oculto" onclick="convertir_HTML_A_PDF();">Descargar PDF</button>
            <a href="moduloAdministrador.jsp">volver</a>
        </div>
    </body>
</html>
