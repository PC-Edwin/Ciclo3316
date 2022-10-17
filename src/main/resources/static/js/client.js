function traerInformacionClient(){
    $.ajax(
              {
                url:"http://localhost:8080/api/Client/all",
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    pintarRespuestaClient(respuesta);
                    
                }
                    
              }
               
          );
}


function pintarRespuestaClient(items){

     $("#resultado").empty();

    //declarar variables js
    let myTableC="<table>";
    myTableC += "<tr><th>Id</th><th>Name</th><th>Email</th><th>Age</th></tr>";
    for(i=0;i<items.length;i++){
        myTableC+="<tr>";
        myTableC+="<td>"+items[i].idClient+"</td>";
        myTableC+="<td>"+items[i].name+"</td>";
        myTableC+="<td>"+items[i].email+"</td>";
        myTableC+="<td>"+items[i].age+"</td>";               
        myTableC+="<td><button onclick='borrarElementoClient("+items[i].idClient+")'>Borrar</button>";
        myTableC+="</tr>";
    }
    myTableC +="</table>";
    $("#resultado").append(myTableC);
}

function guardarInformacionClient(){

    $("#resultado").empty();

    let myDataC ={name:$("#nameC").val(),email:$("#emailC").val(),password:$("#passwordC").val(),age:$("#ageC").val()}
    let dataToSendC = JSON.stringify(myDataC);

    $.ajax (
        {

            url          : 'http://localhost:8080/api/Client/save',
            type         : 'POST',
            data         :  dataToSendC,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){
                            //console.log(respuesta);
                            alert("Inserción exitosa");
                            },
            error       :   function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }

        }
    );
}


function editarInformacionClient(){
                 
    let myDataC ={idClient:$("#idClient").val(),name:$("#nameC").val(),email:$("#emailC").val(),age:$("#ageC").val()}
    let dataToSend = JSON.stringify(myDataC);
    
    $.ajax (
                {

                    url          : 'http://localhost:8080/api/Client/update',
                    type         : 'PUT',
                    data         :  dataToSend,
                    datatype     :  "JSON",
                    contentType  : 'application/json',                    
                    success      :  function(respuesta){
                                        //console.log(respuesta);
                                        alert("Actualizacion exitosa");
                                    },
                    error       :   function(xhr,status){
                                        alert('Operacion no satisfactoria,'+ xhr.status );
                                    }

                }
            );

}

function borrarElementoClient(idElemento){

    
    let myData ={idClient:idElemento}
    let dataToSend   = JSON.stringify(myData);

    $.ajax (
        {

            url          : 'http://localhost:8080/api/Client/' + idElemento,
            type         : 'DELETE',
            data         :  dataToSend,
            contentType  : 'application/json',
            datatype     :  "JSON",
            success      :  function(respuesta){
                                // console.log(respuesta);
                                alert("Borrado exitoso");
                            },
            error       :   function(xhr,status){                                
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }
        }
    );


}


/*function consultarIdClient(idElemento) {

    let codigo = $("#idC").val();
    
    $.ajax (
                {

                    url          : 'https://gffa671b3ff9efe-ciclo3.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client/' + codigo ,
                    type         : 'GET',
                    dataType     : 'json',
                    success      :  function(respuesta){
                                       pintarRespuestaClient(respuesta.items);
                                    },
                    error       :   function(xhr,status){
                                        alert('Operacion no satisfactoria,'+ xhr.status );
                                    },



                }
            );



}*/
