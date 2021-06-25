/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */

/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
var session = window.sessionStorage;
var url = "http://localhost:8085/Cinema";
var posterUrl = "https://www.themoviedb.org/t/p/w1280";

function cerrar(){
    session.removeItem('id');
    session.removeItem('rol');
    location.href = "index.jsp";
}

function getNombreCliente(){
   document.getElementById("titulo").innerHTML = "Bienvenido, " + session.getItem('id');
   cargarCartelera();
}
