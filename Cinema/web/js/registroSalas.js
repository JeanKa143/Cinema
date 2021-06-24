/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */


function verificar(idFormulario) {
    var f = document.getElementById(idFormulario);

    //console.log(f["numero"].value);
    verificarSala(f);

    return false;
}


async function verificarSala(formulario) {
    let f = formulario;

    if (await existeSala(f)) {
        window.alert(`Ya existe una sala con el numero ${f["numero"].value}`);
    } else {
        agregarSala(f);
    }
}

//Verifica si ya existe una sala registrada con la identificacion brindada por el usuario.
async function existeSala(formulario) {
    let f = formulario;
    let request = new Request(`../api/salas/${f["numero"].value}`, {method: 'GET'});
    let resultado = await fetch(request);

    if (!resultado.ok) {
        return false;
    }

    return true;
}

//Se envian los datos del cliente al servidor para registrarlo en la base de datos
function agregarSala(formulario) {
    var f = formulario;
    let request = new Request('../api/salas',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    numero: f["numero"].value,
                    capacidad: f["capacidad"].value
                })
            });             
    fetch(request)
            .then(resultado => {
                if (!resultado.ok) {
                    if (resultado.status === 500) {
                        window.alert('Ha ocurriodo un error al procesar la información.');
                    }
                } else {
                    alert("Sala ingresada con exito");
                    window.location = 'moduloAdministrador.jsp';
                }
            });
}