/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */


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


var BASE_URL = "https://api.themoviedb.org/3/search/movie?api_key=0d794e8c0e28bd18cda507adafeda032&query="; //solicitud de API

function verificar(idFormulario) {
    let form = document.getElementById(idFormulario);

    var f = document.getElementById(idFormulario);
    verificarPelicula(f);

    return false;
}

async function verificarPelicula(formulario) {
    let f = formulario;

    if (await existePelicula(f)) {
        window.alert(`Ya existe una pelicula registrada con este nombre`);
    } else {
        buscarPelicula(f);
    }
}

//Verifica si ya existe una pelicula registrada con la identificacion brindada por el usuario.
async function existePelicula(formulario) {
    let f = formulario;
    let request = new Request(`../api/peliculas/${f["titulo"].value}`, {method: 'GET'});
    let resultado = await fetch(request);

    if (!resultado.ok) {
        if (resultado['status'] === 404) {
            return false;
        }
    }

    return true;
}


//Se busca la pelicula en la API
function buscarPelicula(formulario) {
    let nombre = formulario["titulo"].value;
    let request = BASE_URL + nombre;
    fetch(request).then(
            resultado => resultado.json()
    ).then(resultado => {
        let titulo = resultado.results[0].original_title;
        let id = resultado.results[0].id;
        let poster = resultado.results[0].poster_path;
        let data = resultado.results[0].overview;
        agregar(titulo, id, poster, data, formulario);
    }).catch(() => {
        alert("La pelicula que busca no se encuentra");
    });

}

//Se envian los datos del cliente al servidor para registrarlo en la base de datos
function agregar(t, i, p, d, formulario) {

    let titulo = t;
    let id = i.toString();
    let poster = p;
    let data = d;
    let cartelera = formulario["cartelera"].value;

    let request = new Request('../api/peliculas',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    id_pelicula: id,
                    titulo: titulo,
                    poster_path: poster,
                    movie_data: data,
                    cartelera: cartelera
                })
            });

    fetch(request)
            .then(resultado => {
                if (!resultado.ok) {
                    if (resultado.status === 500) {
                        window.alert('Ha ocurriodo un error al procesar la información.');
                    }
                } else {
                    alert("La pelicula " + titulo + " fue registrada");
                    window.location = "moduloAdministrador.jsp";
                }
            });
}


