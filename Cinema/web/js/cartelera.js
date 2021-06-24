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
        refSeccion.appendChild(img);
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
