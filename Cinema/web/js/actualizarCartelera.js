/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
/* global fetch */

var posterUrl = "https://www.themoviedb.org/t/p/w1280";
var datosPelicula;

function actualizar(idFormulario) {
    var f = document.getElementById(idFormulario);

    return false;
}

function agregar() {
    datosPelicula['cartelera'] = true;
    enviarDatos('La pelicula ahora se muestra en cartelera.');

}

function quitar() {
    datosPelicula['cartelera'] = false;
    enviarDatos('La pelicula ya no se muestra en cartelera.');
}

function enviarDatos(mensaje) {
    let request = new Request('../api/peliculas',
            {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(datosPelicula)
            });

    fetch(request).then(resultado => {
        if (resultado.ok) {
            window.alert(mensaje);
        } else {
            window.alert('Ha ocurriodo un error al procesar la información.');
        }
    });
}

function mostrarPelicula() {
    var tituloPelicula = document.getElementById('pelicula').value;
    var poster = document.getElementById('poster');
    var infoPelicula = document.getElementsByClassName('oculto');

    if (tituloPelicula !== "") {
        let request = new Request(`../api/peliculas/${tituloPelicula}`, {method: 'GET'});

        fetch(request)
                .then(resultado => {
                    if (resultado.ok) {
                        resultado.json().then(
                                datos => {
                                    datosPelicula = datos;
                                    poster.setAttribute('src', posterUrl + datos['poster_path']);
                                    document.getElementById('titulo').innerHTML = datos['titulo'];
                                    document.getElementById('pelicula').value = "";

                                    for (i = 0; i < infoPelicula.length; i++) {
                                        console.log(infoPelicula[i].style.display = "block");
                                    }
                                }
                        );
                    } else {
                        datosPelicula = null;
                        poster.setAttribute('src', '');
                        document.getElementById('titulo').innerHTML = '';
                        document.getElementById('pelicula').value = "";

                        for (i = 0; i < infoPelicula.length; i++) {
                            console.log(infoPelicula[i].style.display = "none");
                        }
                        window.alert('No se ha encontrado la pelicula.');
                    }
                });
    }
}

