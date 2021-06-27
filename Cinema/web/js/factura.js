/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */

function agregarFactura(idFormulario) {
    var f = document.getElementById(idFormulario);
    let date = new Date();
    let idCliente = session.getItem('id');
    console.log(idCliente);
s
    let request = new Request(`../api/facturas/${idCliente}`,
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    seq_factura: 2,
                    fecha: date,
                    tarjeta_pago: "null",
                    cliente_id: idCliente,
                    cliente_usuario_id: idCliente
                    
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