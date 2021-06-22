/* 
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */

var session = window.sessionStorage;
async function inicio() {
    var id = document.getElementById("id").value;
    var pass = document.getElementById("pass").value;

    let request = new Request(`../api/login/${id}`, {method: 'GET', headers: {}});
    let response = await fetch(request);
    if (!response.ok) {
        if (response['status'] === 404) {
            alert("Usuario invalido");
        }
    } else {
        let resultado = await response.json();
        if (resultado.password === pass) {
            console.log(resultado);
            if (session.getItem('id') === null) {
                session.setItem('id', resultado.id);
                session.setItem('rol', resultado.rol);
                alert('Sesión iniciada con exito');
                if(resultado.rol==='administrador'){
                    location.href="moduloAdministrador.jsp";
                }
                else{
                    location.href="moduloCliente.jsp";
                }
                
            } else {
                alert('Ya ha iniciado sesión');
            }
        } else {
            alert("Contraseña invalida");
        }
    }
}


