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
        <link href="CSS/login.css" rel="stylesheet" type="text/css"/>
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
            <form method="GET" action="ServletLogin">
                <p>
                    <input type="number" min ="1" name="id" placeholder="Usuario" required/><br>
                    <input type="password" name="clave" placeholder="Contraseña" required/>
                </p>
                <p>
                    <button type = "submit"> Acceder </button><br>
                </p>
                <p>
                    <a href="registroUusario.jsp" style="text-decoration:none">Registrarse</a>
                </p>
            </form>
            <p id="pfinal">
                <a href="index.html" style="text-decoration:none">Volver</a>
            </p>
        </div>
    </body>
</html>