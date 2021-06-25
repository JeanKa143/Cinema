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
let cantidadButacas = 0;
let butacas =  document.getElementById('butacas');

gallery.addEventListener('dblclick', (e) => {
     e.target.classList.add('red');
     cantidadButacas++;
     butacas.innerHTML = cantidadButacas;
     butacas.setAttribute("value", cantidadButacas);
});

gallery.addEventListener('click', (e) => {
    e.target.classList.remove('red');
    cantidadButacas--;
    butacas.innerHTML = cantidadButacas;
    butacas.setAttribute("value", cantidadButacas);
});

let titular = document.getElementById('titular');
let movieName = document.getElementById('movieName');

function cargarButacas(){
    movieName.innerHTML = titular.getAttribute('value');
  
    for(let init = 65; init < 73; init++){
        for(let init2 = 1; init2 < 10; init2++){
            let butaca = document.createElement('DIV');
            butaca.setAttribute('class', 'gallery_item');
            butaca.innerHTML = String.fromCharCode(init) + init2;
            gallery.appendChild(butaca);
        }
    }
}

window.onload = cargarButacas; 