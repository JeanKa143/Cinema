/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */

const gallery = document.getElementById('gallery');
let cantidadButacas = 0;
let butacas =  document.getElementById('butacas');

var url = "http://localhost:8085/Cinema";
var posterUrl = "https://www.themoviedb.org/t/p/w1280";
var session = window.sessionStorage;


function init() {
    alert("Haga click sobre la pelicula para reservar entradas");
    cargarCartelera;
}


function cargarCartelera() {
    var ref = document.getElementById("galeria");
    if (ref) {
        let request = new Request('../api/cartelera/filtrar', {method: 'GET', headers: {}});
        fetch(request).then(
                resultado => resultado.json()
        ).then(resultado => {
            actualizar(ref, resultado);
        });
    }
}

function actualizar(ref, info) {
    var refSeccion = ref;
    for (var i = 0; i < Object.keys(info).length; i++) {
        var img = document.createElement('IMG');
        img.setAttribute('src', `${posterUrl}${info[i].poster_path}`);
        img.setAttribute('class', 'galery_item');
        refSeccion.appendChild(img);
    }
    
    let imagenes = document.querySelectorAll('.galery_item');
    let titular = document.querySelector('#titular');

    let contador = 0;
    for (let i = 0; i < imagenes.length; i++) {
         imagenes[i].addEventListener('click', function() {
             if(session.getItem('id') !== null){
                titular.innerHTML = `${info[i].titulo}` + ' ha sido seleccionada para la compra';
                titular.setAttribute('value', `${info[i].titulo}`);
                if(contador === 0){
                    contador++;
                    cargarButacas();
                }
                else{
                    location.reload();
                }
             }
             else  location.href="login.jsp";
     });
    }
}

window.onload = init;


gallery.addEventListener('click', (e) => {
     if(e.target.classList.value === 'gallery_item red'){
          cantidadButacas--;
          e.target.classList.remove('red');
          butacas.innerHTML = `${cantidadButacas}`;
          butacas.setAttribute("value", cantidadButacas);
     }
     else{
         e.target.classList.add('red');
        cantidadButacas++;
        butacas.innerHTML = `${cantidadButacas}`;
        butacas.setAttribute("value", cantidadButacas);
     }
     
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

window.onload = init; 