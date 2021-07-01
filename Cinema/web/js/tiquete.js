/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
var numeroTiquete;

function convertir_HTML_A_PDF() {
    var doc = new jsPDF();
    var elementHandler = {
        '#ignorePDF': function (element, renderer) {
            return true;
        }
    };
    var source = document.getElementById('infoTiquete');
    var clone = source.cloneNode(true);

    doc.fromHTML(clone, 25, 10, {
        'width': 75,
        'elementHandlers': elementHandler
    });

    doc.save(`tiqueteNo.${numeroTiquete}.pdf`);
}

function buscarTiquete(idFormulario) {
    var f = document.getElementById(idFormulario);
    var request = new Request(`../api/tiquetes/${f['idTiquete'].value}`, {method: 'GET'});

    fetch(request)
            .then(resultado => {
                if (resultado.ok) {
                    resultado.json().then(datos => mostrarTiquete(datos));
                } else {
                    if (resultado.status === 404) {
                        window.alert('No se ha encontrado el tiquete.');
                    } else {
                        window.alert('Ha ocurrido un error.');
                    }
                    ocultarElementos();
                    deleteChild('infoTiquete');
                }
            });
            
    return false;
}

function mostrarTiquete(tiquete) {
    var elementos = document.getElementsByClassName('oculto');
    infoTiquete(tiquete);

    for (i = 0; i < elementos.length; i++) {
        elementos[i].style.display = "initial";
    }
}

function ocultarElementos() {
    var elementos = document.getElementsByClassName('oculto');
    for (i = 0; i < elementos.length; i++) {
        elementos[i].style.display = "none";
    }
}

function infoTiquete(tiquete) {
    var infoTiquete = document.getElementById('infoTiquete');
    var h1 = document.createElement('h1');
    var p1 = document.createElement('p');
    var p2 = document.createElement('p');
    var p3 = document.createElement('p');
    numeroTiquete = tiquete['id_tiquete'];

    h1.innerHTML = `Tiquete No.${tiquete['id_tiquete']}`;
    p1.innerHTML = `Funcion: ${tiquete['asiento_funcion_funcion_id']} | Sala: ${tiquete['asiento_funcion_funcion_sala_numero']}`;
    p2.innerHTML = `Fecha: ${tiquete['asiento_funcion_funcion_fecha']}`;
    p3.innerHTML = `Asiento: ${tiquete['asiento_funcion_fila']}${tiquete['asiento_funcion_posicion']}`;

    infoTiquete.appendChild(h1);
    infoTiquete.appendChild(p1);
    infoTiquete.appendChild(p2);
    infoTiquete.appendChild(p3);
}


function deleteChild(elementId) {
    var element = document.getElementById(elementId);
    var child = element.lastElementChild;

    while (child) {
        element.removeChild(child);
        child = element.lastElementChild;
    }
}