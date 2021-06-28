/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
 let seq = 0;
function agregarFactura(idFormulario) {
    var f = document.getElementById(idFormulario);
    let idCliente = session.getItem('id');
    let date = new Date();
    let request = new Request('../api/facturas',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    seq_factura: String.valueOf(seq),
                    fecha: String.valueOf(date),
                    tarjeta_pago: String.valueOf(idCliente),
                    cliente_id:  String.valueOf(idCliente),
                    cliente_usuario_id:  String.valueOf(idCliente)
                    
                })
            });

    fetch(request)
            .then(resultado => {
                if (resultado.ok) {
                    seq++;
                    window.alert('Funcion creada con exito.');
            
                } else {
                    window.alert('Ha ocurrido un problema.');
                }
            });

    return false;
}
