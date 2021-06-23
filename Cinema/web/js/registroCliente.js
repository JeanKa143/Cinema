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

function verificar(idFormulario) {
    var f = document.getElementById(idFormulario);

    verificarRegistro(f);

    return false;
}

async function verificarRegistro(formulario) {
    let f = formulario;

    if (await existeCliente(f)) {
        window.alert(`Ya existe un usuario con la identificación: ${f["idCliente"].value}`);
    } else if (await existeUsuario(f)) {
        window.alert(`El usuario '${f["id"].value}' ya está en uso`);
    } else {
        agregarCliente(f);
    }
}

//Verifica si ya existe un cliente registrado con la identificacion brindada por el usuario.
async function existeCliente(formulario) {
    let f = formulario;
    let request = new Request(`../api/clientes/${f["idCliente"].value}`, {method: 'GET'});
    let resultado = await fetch(request);

    if (!resultado.ok) {
        if (resultado['status'] === 404) {
            return false;
        }
    }

    return true;
}

//Verifica si ya existe un cliente registrado con el nombre de usuario brindada por el usuario.
async function existeUsuario(formulario) {
    return false;
}

//Se envian los datos del cliente al servidor para registrarlo en la base de datos
function agregarCliente(formulario) {
    var f = formulario;
    let request = new Request('../api/clientes',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    idCliente: f["idCliente"].value,
                    nombre: f["nombre"].value,
                    apellidos: f["apellidos"].value,
                    telefono: f["telefono"].value,
                    tarjeta_pago: f["tarjeta_pago"].value,
                    id: f["id"].value,
                    clave: f["clave"].value
                })
            });

    fetch(request)
            .then(resultado => {
                if (!resultado.ok) {
                    if (resultado.status === 500) {
                        window.alert('Ha ocurriodo un error al procesar la información.');
                    }
                } else {
                    window.location = "login.jsp"; //Cambiar: redireccionar al login!!!!!
                }
            });
}