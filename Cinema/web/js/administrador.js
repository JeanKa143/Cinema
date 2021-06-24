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
var posterUrl = "https://www.themoviedb.org/t/p/w1280";
function cerrar(){
    session.removeItem('id');
    session.removeItem('rol');
    location.href = "index.jsp";
}

function init() {
    cargarCartelera();
}

function cargarCartelera() {
    var ref = document.getElementById("galeria");
    if (ref) {
        let request = new Request('../api/cartelera', {method: 'GET', headers: {}});
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
window.onload = init;