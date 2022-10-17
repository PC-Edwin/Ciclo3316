function traerInformacionReservation(){
    $.ajax(
              {
                url:"http://150.230.177.169:81/api/Reservation/all",
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    pintarRespuestaReservation(respuesta);
                    
                }
                    
              }
               
          );
}


function pintarRespuestaReservation(items){

     $("#resultado").empty();

    //declarar variables js
    let myTableM="<table>";
    myTableM += "<tr><th>Id</th><th>startDateReservation</th><th>devolutionDateReservation</th><th>statusReservation</th><th>PartyroomName</th><th>PartyroomOwner</th><th>PartyroomCapacity</th><th>PartyroomDescription</th><th>CategoryName</th><th>CategoryDescription</th><th>messageMessageText</th><th>ClientName</th><th>ClientEmail</th><th>ClientPassword</th><th>ClientAge</th><th>reservationsScore</th></tr>";
    for(i=0;i<items.length;i++){
        myTableM+="<tr>";
        myTableM+="<td>"+items[i].idReservation+"</td>";
        myTableM+="<td>"+items[i].startDate+"</td>";
        myTableM+="<td>"+items[i].devolutionDate+"</td>";
        myTableM+="<td>"+items[i].status+"</td>";
        myTableM+="<td>"+items[i].partyroom.name+"</td>"
        myTableM+="<td>"+items[i].partyroom.owner+"</td>";
        myTableM+="<td>"+items[i].partyroom.capacity+"</td>";
        myTableM+="<td>"+items[i].partyroom.description+"</td>";
        myTableM+="<td>"+items[i].partyroom.category.name+"</td>";
        myTableM+="<td>"+items[i].partyroom.category.description+"</td>";
        myTableM+="<td>"+items[i].partyroom.messages.messageText+"</td>";
        myTableM+="<td>"+items[i].client.name+"</td>";
        myTableM+="<td>"+items[i].client.email+"</td>";
        myTableM+="<td>"+items[i].client.password+"</td>";
        myTableM+="<td>"+items[i].client.age+"</td>";
        myTableM+="<td>"+items[i].score+"</td>";                           
        myTableM+="<td><button onclick='borrarElementoReservation("+items[i].idReservation+")'>Borrar</button>";
        myTableM+="</tr>";
    }
    myTableM +="</table>";
    $("#resultado").append(myTableM);
}

function guardarInformacionReservation(){

    $("#resultado").empty();

    let myDataM ={startDate:$("#startDate").val(),devolutionDate:$("#devolutiontDate").val(),partyroom:{id:$("#idRoom").val()},client:{idClient:$("#idClien").val()}}
    let dataToSendM = JSON.stringify(myDataM);

    $.ajax (
        {

            url          : 'http://150.230.177.169:81/api/Reservation/save',
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

function editarInformacionReservation(){
                 
    let myData ={idReservation:$("#idReserva").val(),startDate:$("#startDate").val(),devolutionDate:$("#devolutiontDate").val(),partyroom:{id:$("#idRoom").val()},client:{idClient:$("#idClien").val()}}
    let dataToSend = JSON.stringify(myData);
    
    $.ajax (
                {

                    url          : 'http://150.230.177.169:81/api/Reservation/update',
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

function borrarElementoReservation(idElemento){

    
    let myData ={idReservation:idElemento}
    let dataToSend   = JSON.stringify(myData);

    $.ajax (
        {

            url          : 'http://150.230.177.169:81/api/Reservation/' + idElemento,
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


function consultarTopClientes() {
    $.ajax(
        {
        url:'http://150.230.177.169:81/api/Reservation/report-status',
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            pintarRespuestaReservationStatus(respuesta);
            
        }
            
        }
        
    );
}

function pintarRespuestaReservationStatus(items){

    $("#resultado").empty();

   //declarar variables js
   let myTableM="<table>";
   myTableM += "<tr><th>Completed</th><th>Cancelled</th></tr>";
   for(i=0;i<items.length;i++){
       myTableM+="<tr>";
       myTableM+="<td>"+items[i].StatusReserva.completed+"</td>";
       myTableM+="<td>"+items[i].StatusReservas.cancelled+"</td>";                      
       myTableM+="<td><button onclick='borrarElementoReservation("+items[i].idReservation+")'>Borrar</button>";
       myTableM+="</tr>";
   }
   myTableM +="</table>";
   $("#resultado").append(myTableM);
}