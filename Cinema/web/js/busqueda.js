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
    console.log(idx);
    var ref = document.getElementById("search");

    if (ref) {
        var newDiv = document.createElement("div");
        newDiv.setAttribute('id','pop-up');
        var img = document.createElement('IMG');
        img.setAttribute('id','pop-up-img');
        img.setAttribute('src', `${posterUrl}${idx.poster_path}`);
        newDiv.appendChild(img);
        var title = document.createTextNode('Nombre de la pelicula: \n'+ idx.titulo);
        var id = document.createTextNode('El ID de la pelicula es: '+ idx.id_pelicula);
        var sinopsis = document.createTextNode('Sinopsis: '+ idx.movie_data);
        var enter = document.createElement('br');
        newDiv.appendChild(title);
        newDiv.appendChild(enter);
        newDiv.appendChild(id);
        newDiv.appendChild(enter);
        newDiv.appendChild(sinopsis);
        
        ref.appendChild(newDiv);

    }


    alternar();

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

