function traerInformacionMessage(){
    $.ajax(
              {
                url:"http://150.230.177.169:81/api/Message/all",
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    pintarRespuestaMessage(respuesta);
                    
                }
                    
              }
               
          );
}


function pintarRespuestaMessage(items){

     $("#resultado").empty();

    //declarar variables js
    let myTableM="<table>";
    myTableM += "<thead><tr><th>Id</th><th>MessageText</th><th>PartyroomName</th><th>PartyroomOwner</th><th>PartyroomCapacity</th><th>PartyroomDescription</th><th>CategoryName</th><th>CategoryDescription</th><th>ClientName</th><th>ClientEmail</th><th>ClientPassword</th><th>ClientAge</th></tr></thead>";
    for(i=0;i<items.length;i++){
        myTableM+="<tr>";
        myTableM+="<td>"+items[i].idMessage+"</td>";
        myTableM+="<td>"+items[i].messageText+"</td>";
        myTableM+="<td>"+items[i].partyroom.name+"</td>";
        myTableM+="<td>"+items[i].partyroom.owner+"</td>";
        myTableM+="<td>"+items[i].partyroom.capacity+"</td>";
        myTableM+="<td>"+items[i].partyroom.description+"</td>";
        myTableM+="<td>"+items[i].partyroom.category.name+"</td>";
        myTableM+="<td>"+items[i].partyroom.category.description+"</td>";
        myTableM+="<td>"+items[i].client.name+"</td>";
        myTableM+="<td>"+items[i].client.email+"</td>";
        myTableM+="<td>"+items[i].client.password+"</td>";
        myTableM+="<td>"+items[i].client.age+"</td>";                          
        myTableM+="<td><button onclick='borrarElementoMessage("+items[i].idMessage+")'>Borrar</button>";
        myTableM+="</tr>";
    }
    myTableM +="</table>";
    $("#resultado").append(myTableM);
}

function guardarInformacionMessage(){

    $("#resultado").empty();

    let myDataM ={messageText:$("#messagetext").val(),partyroom:{id:$("#idPart").val()},client:{idClient:$("#idClie").val()}}
    let dataToSendM = JSON.stringify(myDataM);

    $.ajax (
        {

            url          : 'http://150.230.177.169:81/api/Message/save',
            type         : 'POST',
            data         :  dataToSendM,
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

function editarInformacionMessage(){
                 
    let myDataM ={idMessage:$("#idM").val(),messageText:$("#messagetext").val(),partyroom:{id:$("#idPart").val()},client:{idClient:$("#idClie").val()}}
    let dataToSendM = JSON.stringify(myDataM);
    
    $.ajax (
                {

                    url          : 'http://150.230.177.169:81/api/Message/update',
                    type         : 'PUT',
                    data         :  dataToSendM,
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

function borrarElementoMessage(idElemento){

    
    let myDataM ={idMessage:idElemento}
    let dataToSendM   = JSON.stringify(myDataM);

    $.ajax (
        {

            url          : 'http://150.230.177.169:81/api/Message/' + idElemento,
            type         : 'DELETE',
            data         :  dataToSendM,
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


/*function consultarIdMessage(idElemento) {

    let codigo = $("#idM").val();
    
    $.ajax (
                {

                    url          : 'https://gffa671b3ff9efe-ciclo3.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message/' + codigo ,
                    type         : 'GET',
                    dataType     : 'json',
                    success      :  function(respuesta){
                                       pintarRespuestaMessage(respuesta.items);
                                    },
                    error       :   function(xhr,status){
                                        alert('Operacion no satisfactoria,'+ xhr.status );
                                    },



                }
            );



}*/
