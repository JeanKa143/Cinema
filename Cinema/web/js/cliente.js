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
/* global fetch */

var session = window.sessionStorage;

function cerrar(){
    session.removeItem('id');
    session.removeItem('rol');
    location.href = "index.jsp";
}

function getNombreCliente(){
   document.getElementById("titulo").innerHTML += "Bienvenido, " + session.getItem('id');
   if(document.getElementById('galeria')){
          cargarCartelera();
   }
}
window.onload = getNombreCliente;