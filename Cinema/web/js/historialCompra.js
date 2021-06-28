/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
let session = window.sessionStorage;

let idFactura;
let usuario;
let id;
let fecha; 
     
async function cargarFactura(formulario) {
let f = formulario;
    var porNombre = document.getElementsByName("id")[0].value;
     
    let request = new Request(`../api/compras/${porNombre}`, {method: 'GET', headers: {}});
      console.log(request);
      fetch(request).then(
              resultado => resultado.json()
      ).then(resultado => {
          resultado.JSON;
        let a = document.getElementById('factura');
          idFactura =  resultado.seq_factura ;
          cliente = resultado.cliente_usuario_id;
          usuario = resultado.cliente_id;
          fecha = resultado.fecha;
          
          if(cliente !== session.getItem('id')){
               alert("La factura no se encuentra a su nombre");
          }
          else if(cliente === session.getItem('id')){
                a.innerHTML = "El id de la factura es" + resultado.seq_factura + "<br> La factura esta a nombre de: " + resultado.cliente_usuario_id +
                "<br> La factura fue comprada el:  " + resultado.fecha ;
          }
 
      }).catch(() => {
          alert("La compra que busca no se encuentra");
      });
    
    return true;
}


function generaPDF(){
      
    if(cliente !== session.getItem('id')){
         alert("La factura no se encuentra a su nombre");
    }
    else if(cliente === session.getItem('id')){
         var doc = new jsPDF();
        doc.text(20, 20, 'Factura por compra de boletos a NGC Cinemas');
        doc.setFontSize(16);
        doc.text(50, 40, "El id de la factura es: " + idFactura);
        doc.text(50, 50, "La factura esta a nombre de usuario: " + cliente);
        doc.text(50, 60, "La factura esta a nombre de cliente: " + usuario);
        doc.text(50, 70, "Fecha de facturación: " + fecha);

        doc.text(50, 90, "GRACIAS POR PREFERIRNOS!!!");
        doc.save(`Factura_${fecha}.pdf`);
    }
          
   
}

