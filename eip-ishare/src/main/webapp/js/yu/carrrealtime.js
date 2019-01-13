$(function(){
	//car sensor real time 
	//var ws2 = new WebSocket("ws://18.191.197.106:8080/eip-ishare/carsensordtlws.do");
	var ws2 = new WebSocket("ws://127.0.0.1:8080/eip-ishare/carsensordtlws.do");

	ws2.onopen = function()

	{  console.log("open");

	  // ws.send();

	};
	ws2.onmessage = function(evt)

	{
	  console.log(evt.data)
	  var data=JSON.parse(evt.data);
	  var time=timestampToTime(data.inputDt);
		 // data.inputDt.substring(data.inputDt.length-8)
	  //data=data.loss;
	  if(data !=undefined){
	  //for(var i=0;i<data.length;i++){
	  	 // var list="<tr class='gradeX'><td>"+time+"</td><td>"+data[i].deviceId+"</td><td>"+data[i].carStatus+"</td><td>"+data[i].nbSignalPwr+"</td><td>"+data[i].battVol+"</td><td>"+data[i].dataType+"</td><td>"+data[i].dataLen+"</td></tr>"
	  	  var list="<tr class='gradeX'><td>"+time+"</td><td>"+data.device.deviceDesc+"</td><td>"+data.carStatus+"</td><td>"+data.nbSignalPwr+"</td><td>"+data.battVol+"</td><td>"+data.dataType+"</td><td>"+data.dataLen+"</td></tr>"
		 
	  	  $(".ly-car tbody").append(list);
	  	  
	 // }
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
	
	function timestampToTime(timestamp) {
		   var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		   Y = date.getFullYear() + '-';
		   M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		   D = date.getDate() + ' ';
		   h = date.getHours() + ':';
		   m = date.getMinutes() + ':';
		   s = date.getSeconds();
		   return Y+M+D;
	}

})