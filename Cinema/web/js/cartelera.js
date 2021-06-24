var url = "http://localhost:8085/Cinema";
var posterUrl = "https://www.themoviedb.org/t/p/w1280";
var session = window.sessionStorage;

function init() {
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
        
         titular.innerText = `${info[i].titulo}` + '\n' + 'Sinopsis: ' + `${info[i].movie_data}`;
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
