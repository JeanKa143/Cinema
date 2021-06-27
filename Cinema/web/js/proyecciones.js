/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */

/* global datosPelicula */

function crearProyeccion(idFormulario) {
    var f = document.getElementById(idFormulario);
    let request = new Request('../api/funciones',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    fecha: f["fecha"].value,
                    hora: f["hora"].value,
                    sala_numero: f["salas"].value,
                    pelicula_id: datosPelicula['id_pelicula']
                })
            });

    fetch(request)
            .then(resultado => {
                if (resultado.ok) {
                    window.alert('Funcion creada con exito.');
                } else {
                    window.alert('Ha ocurrido un problema.');
                }
            });

    return false;
}

//Carga la lista de salas
function init() {
    var listaSalas = document.getElementById('salas');
    let request = new Request('../api/salas', {method: 'GET'});

    fetch(request)
            .then(resultado => {
                if (resultado.ok) {
                    resultado.json()
                            .then(datos => {
                                for (let i = 0; i < datos.length; i++) {
                                    let o = document.createElement('option');
                                    o.setAttribute('value', datos[i]['id']);
                                    o.innerHTML = datos[i]['id'];
                                    listaSalas.appendChild(o);
                                }
                            });
                } else {
                    window.alert('No se han encontrado salas disponibles.');
                }
            });
}

window.onload = init;