$(function(){
	//car sensor real time 
	var ws2 = new WebSocket("ws://18.191.197.106:8080/eip-ishare/carsensordtlws.do");

	ws2.onopen = function()

	{  console.log("open");

	  // ws.send();

	};
	ws2.onmessage = function(evt)

	{
	  console.log(evt.data)
	  var data=JSON.parse(evt.data);
	  var time=data.inputDt.substring(data.inputDt.length-8)
	  data=data.loss;
	  for(var i=0;i<data.length;i++){
	  	  var list="<tr class='gradeX'><td>"+time+"</td><td>"+data[i].deviceId+"</td><td>"+data[i].carStatus+"</td><td>"+data[i].nbSignalPwr+"</td><td>"+data[i].battVol+"</td><td>"+data[i].dataType+"</td><td>"+data[i].dataLen+"</td></tr>"
		  $(".ly-car tbody").append(list);
	  }
	 }

	ws2.onclose = function(evt)

	{

	  console.log("WebSocketClosed!");

	};

	ws2.onerror = function(evt)

	{

	  console.log("WebSocketError!");

	};
})