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
    var model_contenedor = document.getElementById("modal_contenedor");
    
    if(model_contenedor.childElementCount>1){
        model_contenedor.removeChild(mod);
    }
    if (model_contenedor) {
        var ref = document.createElement('div');
        ref.setAttribute('class', 'moda');
        ref.setAttribute('id', 'mod');
        var titulo = document.createTextNode('Nombre de la pelicula: \n' + idx.titulo);
        var id = document.createTextNode('El ID de la pelicula es: ' + idx.id_pelicula);
        var sinopsis = document.createTextNode('Sinopsis: ' + idx.movie_data);
        var img = document.createElement('img');
        img.setAttribute('id', "pop-up-img");
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


        ref.appendChild(document.createElement("br"));
        ref.appendChild(document.createElement("br"));

        ref.appendChild(img);
        model_contenedor.appendChild(ref);
        model_contenedor.classList.add('show');
    }
}
var btnCerrar = document.getElementById('cerrar-btn');
var modal_contenedor = document.getElementById('modal_contenedor');
if (btnCerrar) {
    btnCerrar.addEventListener('click', () => {
        modal_contenedor.classList.remove('show');
    });
}


