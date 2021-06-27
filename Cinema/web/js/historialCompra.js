/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */

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
            a.innerHTML = resultado.date;
      }).catch(() => {
          alert("La compra que busca no se encuentra");
      });
        
  

    
    return true;
}