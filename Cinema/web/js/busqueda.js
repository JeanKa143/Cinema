/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
var url = "http://localhost:8085/Cinema";
var posterUrl = "https://www.themoviedb.org/t/p/w1280";


var btn = document.getElementById('btn-buscar');
if (btn) {
    btn.addEventListener('click', () => {
        var texto = document.getElementById("busqueda").value;
        cargarPelicula(texto);
    });
}

function cargarPelicula(nombre) {
    var ref = document.getElementById("galeria");
    if (ref) {
        let request = new Request(url + '/api/cartelera/' + nombre, {method: 'GET', headers: {}});
        fetch(request).then(
                resultado => resultado.json()
        ).then(resultado => {
            mostrar(resultado);
        });
    }
}

function mostrar(idx) {
    var ref = document.getElementById("mod");
    var titulo = document.getElementById("titulo");
    var id = document.getElementById("id");
    var sinopsis = document.getElementById("sinopsis");
    var img = document.getElementById("pop-up-img");
    var model_contanedor = document.getElementById("modal_contenedor");
    if (ref) {
        titulo = document.createTextNode('');
        id = document.createTextNode('');
        sinopsis = document.createTextNode('');




        titulo = document.createTextNode('Nombre de la pelicula: \n' + idx.titulo);
        id = document.createTextNode('El ID de la pelicula es: ' + idx.id_pelicula);
        sinopsis = document.createTextNode('Sinopsis: ' + idx.movie_data);
        img.setAttribute('src', `${posterUrl}${idx.poster_path}`);
        ref.appendChild(titulo);
        ref.appendChild(document.createElement("br"));
        ref.appendChild(document.createElement("br"));

        ref.appendChild(id);
        ref.appendChild(document.createElement("br"));
        ref.appendChild(document.createElement("br"));

        ref.appendChild(sinopsis);
        ref.appendChild(document.createElement("br"));
        ref.appendChild(document.createElement("br"));

        ref.appendChild(img);
        model_contanedor.classList.add('show');
//        var cerrar = document.createElement('button');
//        cerrar.setAttribute('id', 'cerrar-btn');
//        cerrar.appendChild(document.createTextNode("Cerrar"));
//
//        divModal.appendChild(title);
//        divModal.appendChild(document.createElement("br"));
//        divModal.appendChild(document.createElement("br"));
//        divModal.appendChild(id);
//        divModal.appendChild(document.createElement("br"));
//        divModal.appendChild(document.createElement("br"));
//        divModal.appendChild(sinopsis);
//        divModal.appendChild(document.createElement("br"));
//        divModal.appendChild(document.createElement("br"));
//        divModal.appendChild(img);
//        divModal.appendChild(document.createElement("br"));
//        divModal.appendChild(document.createElement("br"));
//        divModal.appendChild(cerrar);
//        
//        divContenedor.appendChild(divModal);
//        ref.appendChild(divContenedor);
    }
}
var btnCerrar = document.getElementById('cerrar-btn');
var modal_contenedor = document.getElementById('modal_contenedor');
if (btnCerrar) {
    btnCerrar.addEventListener('click', () => {
        modal_contenedor.classList.remove('show');
    });
}
function alternar() {
    var refA = document.getElementById("page-mask");
    if (refA) {
        if (refA.style.display === "none" || refA.style.display === "") {
            refA.style.display = "block";
        } else {
            refA.style.display = "none";
        }
    }
}

