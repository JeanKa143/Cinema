<%-- 
    Document   : index
    Created on : 17/06/2021, 03:23:34 PM
    Author     : Luis Fallas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <title>Galería</title>
        <meta charset="UTF-8" />
        <link href="../CSS/default.css" rel="stylesheet" type="text/css"/>
        <script src="../js/cartelera.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <header>
                <h1>
                    Cartelera de Cine
                </h1>
            </header>
            <nav>
                <ul>
                    <li><a href="#">Inicio</li>
                    <li><a href="#">Contactenos</li>
                    <li><a href="#">Registro</li>
                    <li><a href="#">Iniciar sesion</li>
                    <li><a href="eleccionAsientoSala.jsp">Asientos</li>
                </ul>
            </nav>
            <div id="contents">
                <section>
                    <table id="galeria" class="galeria">
                        <thead></thead>
                        <tbody>
                        <script type="text/javascript">
                            var m = dimensionTabla.filas;
                            var n = dimensionTabla.columnas;
                            var t = "";
                            for (let i = 0; i < m; i++) {
                                t += "<tr>";
                                for (let j = 0; j < n; j++) {
                                    t += "<td>";
                                    t += "<img />";
                                    t += " <p>(movie title)</p>";
                                    t += "</td>";
                                }
                                t += "</tr>";
                            }
                            document.write(t);
                        </script>
                        </tbody>
                        <tfoot></tfoot>
                    </table>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
