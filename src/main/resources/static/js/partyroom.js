function traerInformacionPartyroom(){
    $.ajax(
              {
                url:"http://150.230.177.169:81/api/Partyroom/all",
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    pintarRespuestaPartyroom(respuesta);                    
                }
                    
              }
               
          );
}


function pintarRespuestaPartyroom(items){

     $("#resultado").empty();

    //declarar variables js
    let myTable="<table>";
    myTable += "<thead><tr><th>Id</th><th>Name</th><th>Owner</th><th>Capacity</th><th>Description</th><th>CategoryName</th><th>CategoryDescription</th></tr></thead>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].owner+"</td>";
        myTable+="<td>"+items[i].capacity+"</td>";
        myTable+="<td>"+items[i].description+"</td>";
        myTable+="<td>"+items[i].category.name+"</td>";
        myTable+="<td>"+items[i].category.description+"</td>";
        myTable+="<td><button onclick='borrarElementoPartyroom("+items[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable +="</table>";
    $("#resultado").append(myTable);
}

function guardarInformacionPartyroom(){

    $("#resultado").empty();

    let myData ={owner:$("#ownerPartyroom").val(),capacity:$("#capacityPartyroom").val(),name:$("#namePartyroom").val(),description:$("#descriptionPartyroom").val(),category:{id:$("#id").val()}}
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {

            url          : 'http://150.230.177.169:81/api/Partyroom/save',
            type         : 'POST',
            data         :  dataToSend,
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


function editarInformacionPartyroom() {
                  
    let myData ={id:$("#idParyroom").val(),owner:$("#ownerPartyroom").val(),capacity:$("#capacityPartyroom").val(),name:$("#namePartyroom").val(),description:$("#descriptionPartyroom").val(),category:{id:$("#id").val()}}
    let dataToSend = JSON.stringify(myData);
    
    $.ajax (
                {

                    url          : 'hhttp://150.230.177.169:81/api/Partyroom/update',
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

function borrarElementoPartyroom(idElemento){

    
    let myData ={id:idElemento}
    let dataToSend   = JSON.stringify(myData);

    $.ajax (
        {

            url          : 'http://150.230.177.169:81/api/Partyroom/' + idElemento,
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


/*function consultarIdPartyroom() {

    let codigo = $("#id").val();
    
    $.ajax (
                {

                    url          : 'https://gffa671b3ff9efe-ciclo3.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/partyroom/partyroom/' + codigo ,
                    type         : 'GET',
                    dataType     : 'json',
                    success      :  function(respuesta){
                                       pintarRespuestaPartyroom(respuesta.items);
                                    },
                    error       :   function(xhr,status){
                                        alert('Operacion no satisfactoria,'+ xhr.status );
                                    },



                }
            );



}*/
