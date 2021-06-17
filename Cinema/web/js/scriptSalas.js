/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */

const form = document.getElementById('form');
const input = document.getElementById('input');
const button = document.getElementById('button');

const gallery = document.getElementById('gallery');
gallery.addEventListener('click', (e) => {
    e.target.classList.add('red');
}) ;
