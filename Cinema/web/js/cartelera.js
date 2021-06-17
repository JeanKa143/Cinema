var url = "http://localhost:8085/Cinema";
var dimensionTabla = {filas: 2, columnas: 5};
var posterUrl = "https://www.themoviedb.org/t/p/w1280";

var APIKEY = "api_key=0d794e8c0e28bd18cda507adafeda032"; //llave
var BASE_URL = "https://api.themoviedb.org/3"; //solicitud de API
var API_URL = BASE_URL + "/discover/movie?sort_by=popularity.desc&" //link de peliculas más populares
        + APIKEY;

var cartelera = new Array();
var peliculas = new Array();
var pelicula = {id_pelicula: "", titulo: "", poster_path: "", movie_data: "", cartelera: ""};

function init() {
    cargarCartelera();
}


function cargarCartelera() {
    var key = APIKEY;
    var ref = document.getElementById("galeria");
    if (ref) {
        var m = ref.rows.length;
        var n = ref.rows[0].cells.length;
        let request = new Request(url + '/api/cartelera/filtrar', {method: 'GET', headers: {}});
        var p = 0;
        fetch(request).then(
                resultado => resultado.json()
        ).then(resultado => {
            for(var i=0; i<10; i++){
                actualizar(ref, resultado[i], m, n, p);
                p++;
            }
        });
    }
}

function actualizar(ref, info, m, n, p) {
var r = p % m;
var c = Math.floor(p / m);
var celda = ref.rows[r].cells[c];
    t = `<img src='${posterUrl}${info.poster_path}' `;
    t += `alt='r${info.poster_path}' />`;
    t += `<p>${info.titulo}</p>`;
    celda.innerHTML = t;
}

window.onload = init;
