var url = "http://localhost:8085/Cinema";
var posterUrl = "https://www.themoviedb.org/t/p/w1280";

var APIKEY = "api_key=0d794e8c0e28bd18cda507adafeda032"; //llave
var BASE_URL = "https://api.themoviedb.org/3"; //solicitud de API
var API_URL = BASE_URL + "/discover/movie?sort_by=popularity.desc&" //link de peliculas más populares
        + APIKEY;

function init() {
    cargarCartelera();
}


function cargarCartelera() {
    var ref = document.getElementById("galeria");
    if (ref) {
        let request = new Request(url + '/api/cartelera/filtrar', {method: 'GET', headers: {}});
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
        img.setAttribute('src',`${posterUrl}${info[i].poster_path}`);
        refSeccion.appendChild(img);
    }
}

window.onload = init;
