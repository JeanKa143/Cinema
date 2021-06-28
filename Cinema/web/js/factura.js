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
    let clienteId = session.getItem('id');
    let usuarioId = session.getItem('id');
    let fecha = new Date();
    let tarjeta_pago = "unaLargaCadena";
   
    console.log(clienteId);
    console.log(usuarioId);
    console.log(fecha);
    console.log(tarjeta_pago);

    let request = new Request('../api/compras',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    seq_factura: 0,
                    cliente_id: clienteId
                })
            });

    fetch(request)
            .then(resultado => {
                if (!resultado.ok) {
                    if (resultado.status === 500) {
                        window.alert('Ha ocurriodo un error al procesar la información.');
                    }
                } else {
                    window.location = "compraEntradas.jsp";
                }
            });
}
