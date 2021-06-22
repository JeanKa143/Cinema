<%-- 
    Document   : login
    Created on : Jun 17, 2021, 2:11:03 AM
    Author     : diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Login</title>
        <link href="../CSS/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="elUsuario" class="modelo.Usuario" scope="session">
        </jsp:useBean>
        <jsp:useBean id="usuarios" class="modelo.conjuntos.ConjuntoUsuarios" scope="application">
        </jsp:useBean>
        <jsp:useBean id="clientes" class="modelo.conjuntos.ConjuntoClientes" scope="application">
        </jsp:useBean>
        <div id="wrapper">
            <h1>Login</h1>
                <p>
                    <input type="text" min ="1" id="id" placeholder="Usuario" required/><br>
                    <input type="password" id="pass" placeholder="Contraseña" required/>
                </p>
                <p>
                    <button onclick="inicio()"> Acceder </button><br>
                </p>
            <p id="pfinal">
                <a href="index.jsp" style="text-decoration:none">Volver</a>
            </p>
        </div>
    </body>
    <script src="../js/login.js" type="text/javascript"></script>
</html>