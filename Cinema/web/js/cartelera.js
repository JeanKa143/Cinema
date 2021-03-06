var url = "http://localhost:8085/Cinema";
var posterUrl = "https://www.themoviedb.org/t/p/w1280";
var session = window.sessionStorage;


function init() {
    alert("Posicione el cursor sobre una pelicula para ver la sinopsis y haga click sobre la pelicula para reservar entradas");
    cargarCartelera();
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

    for (let i = 0; i < imagenes.length; i++) {
         imagenes[i].addEventListener('mouseover', function() {
             titular.innerHTML = `${info[i].titulo}` + '<br> Sinopsis: ' + `${info[i].movie_data}`;
     });
     }
     
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

function login(){
    if(session.getItem('rol')===null){
        location.href="login.jsp";
    }
    else{
        if(session.getItem('rol')==="administrador"){
            location.href="moduloAdministrador.jsp";
        }
        else{
            location.href="moduloCliente.jsp";
        }
    }
    
}

window.onload = init;
