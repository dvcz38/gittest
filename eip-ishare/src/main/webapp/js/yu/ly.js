$(function(){
	//设置当前日期
	var date=new Date();
	var monthEng=['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sept','Oct','Nov','Dec'];
	var month=monthEng[date.getMonth()];
	var day=date.getDate();
	var year=date.getFullYear();
	$(".ly-time i").text(month+" "+day+"th  "+year);




	//巡检
	var maxLength=6;
	function addDataList(data,parent){
		var data=data.rows;
		console.log(data[0].inputDt)
		if($(parent+" li")){
			var divLength=$(parent+" li").length;
		}else{
			var divLength=0;
		}
		var dataLength=data.length;
		var iconclass;
		if(dataLength>=maxLength){//数据超过显示的条数 直接倒叙放入既可
			//清除现有的条目
			$(parent+" li").remove();
			for(var i=dataLength-1;i>=dataLength-maxLength;i--){
				if(data[i].doorStatus=="Close"){
					iconclass="ic-bullet-green"
				}else{
					iconclass="ic-bullet-red"
				}

				data[i].inputDt=data[i].inputDt.substring(data[i].inputDt.length-8);
				if(parent==".ly-auto"){
					var list='<li>'+
                                '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']'+
                             
                            '</li>'
				}else if(parent==".ly-human"){
					var list='<li>'+
                                 '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']-['+data[i].staffno+']'+
                             
                            '</li>'
				}
				

				$(parent).append(list);
			}
		}else if(dataLength+divLength<=maxLength&&divLength!=0){//有li 新数据加旧数据不超过最大值
			for(var i=0;i<dataLength;i++){
				
				if(data[i].doorStatus=="Close"){
					iconclass="ic-bullet-green"
				}else{
					iconclass="ic-bullet-red"
				}
				data[i].inputDt=data[i].inputDt.substring(data[i].inputDt.length-8);
				if(parent==".ly-auto"){
					var list='<li>'+
                                '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']'+
                             
                            '</li>'
				}else{
					var list='<li>'+
                                 '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']-['+data[i].staffno+']'+
                             
                            '</li>'
				}
				$(parent+" li:eq(0)").before(list);
			}
		}else if(dataLength+divLength>maxLength&&divLength!=0&&dataLength<maxLength){//有旧数据 新数据加旧数据超过最大值
			var delLength=(dataLength+divLength)-maxLength;
			for(var z=0;z<delLength;z++){
				var temp=divLength-1-z;
				console.log($(".ly-auto li:eq("+z+")"))
				
				$(parent+" li:eq("+temp+")").remove()

			}
			for(var i=0;i<dataLength;i++){
				
				if(data[i].doorStatus=="Close"){
					iconclass="ic-bullet-green"
				}else{
					iconclass="ic-bullet-red"
				}
				data[i].inputDt=data[i].inputDt.substring(data[i].inputDt.length-8);
				if(parent==".ly-auto"){
					var list='<li>'+
                                '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']'+
                             
                            '</li>'
				}else{
					var list='<li>'+
                                 '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']-['+data[i].staffno+']'+
                             
                            '</li>'
				}
				$(parent+" li:eq(0)").before(list);
			}
		}else if(divLength==0){
			var temp=dataLength-maxLength<=0?0:dataLength-maxLength

			for(var i=dataLength-1;i>=temp;i--){
				
				if(data[i].doorStatus=="Close"){
					iconclass="ic-bullet-green"
				}else{
					iconclass="ic-bullet-red"
				}
				data[i].inputDt=data[i].inputDt.substring(data[i].inputDt.length-8);
				console.log(data[i].doorStatus=="Close")
				if(parent==".ly-auto"){
					var list='<li>'+
                                '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']'+
                             
                            '</li>'
				}else{
					var list='<li>'+
                                 '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']-['+data[i].staffno+']'+
                             
                            '</li>'
				}
				$(parent).append(list);
			}
		}
	}


//	function(){
		//获得通道
		$.ajax({
			url:'/eip-ishare/device/getchannel.do',
			success:function(data){
				if(data.rows.length!=0){
					if($(".ly-channel").find("span").length!=0){
						$(".ly-channel").find("span").remove();
					}
					for(var i=0;i<data.rows.length;i++){
						var span= '<span class=" mws-ic ic-bullet_star ly-bullet_star">Channel '+data.rows[i]+'</span>'
						$(".ly-channel").append(span)
					}
				}
			}
		})
//	}
	
//	window.setInterval(,1000)
	
	var maxtableLength=7;
	function addDatatable(data,parent,time){
		// var data=data.rows;
		var data=data;
		
		if($(parent+" tbody")){
			var divLength=$(parent+" tbody tr").length;
		}else{
			var divLength=0;
		}
		var dataLength=data.length;
		// var iconclass;
		if(dataLength>=maxtableLength){//数据超过显示的条数 直接倒叙放入既可
			//清除现有的条目
			$(parent+" tbody tr").remove();
			for(var i=dataLength-1;i>=dataLength-maxtableLength;i--){
				// if(data[i].doorStatus=="Close"){
				// 	iconclass="ic-bullet-green"
				// }else{
				// 	iconclass="ic-bullet-red"
				// }

				// data[i].inputDt=data[i].inputDt.substring(data[i].inputDt.length-8);
				if(parent==".ly-loss"){
					var list="<tr class='gradeX'><td>"+time+"</td><td>"+data[i].channelNo+"</td><td>"+data[i].deviceDesc+"</td><td>"+data[i].floorNo+"</td></tr>"
				}else if(parent==".ly-human"){
					var list='<li>'+
                                 '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']-['+data[i].staffno+']'+
                             
                            '</li>'
				}
				

				$(parent+" tbody").append(list);
			}
		}else if(dataLength+divLength<=maxtableLength&&divLength!=0){//有li 新数据加旧数据不超过最大值
			for(var i=0;i<dataLength;i++){
				
				// if(data[i].doorStatus=="Close"){
				// 	iconclass="ic-bullet-green"
				// }else{
				// 	iconclass="ic-bullet-red"
				// }
				// data[i].inputDt=data[i].inputDt.substring(data[i].inputDt.length-8);
				if(parent==".ly-loss"){
					var list="<tr class='gradeX'><td>"+time+"</td><td>"+data[i].channelNo+"</td><td>"+data[i].deviceDesc+"</td><td>"+data[i].floorNo+"</td></tr>"
				}else{
					var list='<li>'+
                                 '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']-['+data[i].staffno+']'+
                             
                            '</li>'
				}
				$(parent+" tbody tr:eq(0)").before(list);
			}
		}else if(dataLength+divLength>maxtableLength&&divLength!=0&&dataLength<maxtableLength){//有旧数据 新数据加旧数据超过最大值
			var delLength=(dataLength+divLength)-maxtableLength;
			for(var z=0;z<delLength;z++){
				var temp=divLength-1-z;
				//console.log($(".ly-auto li:eq("+z+")"))
				
				$(parent+" tbody tr:eq("+temp+")").remove()

			}
			for(var i=0;i<dataLength;i++){
				
				// if(data[i].doorStatus=="Close"){
				// 	iconclass="ic-bullet-green"
				// }else{
				// 	iconclass="ic-bullet-red"
				// }
				// data[i].inputDt=data[i].inputDt.substring(data[i].inputDt.length-8);
				if(parent==".ly-loss"){
					var list="<tr class='gradeX'><td>"+time+"</td><td>"+data[i].channelNo+"</td><td>"+data[i].deviceDesc+"</td><td>"+data[i].floorNo+"</td></tr>"
				}else{
					var list='<li>'+
                                 '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']-['+data[i].staffno+']'+
                             
                            '</li>'
				}
				$(parent+" tbody tr:eq(0)").before(list);
			}
		}else if(divLength==0){
			var temp=dataLength-maxtableLength<=0?0:dataLength-maxtableLength

			for(var i=dataLength-1;i>=temp;i--){
				
				// if(data[i].doorStatus=="Close"){
				// 	iconclass="ic-bullet-green"
				// }else{
				// 	iconclass="ic-bullet-red"
				// }
				// data[i].inputDt=data[i].inputDt.substring(data[i].inputDt.length-8);
				console.log(data[i].doorStatus=="Close")
				if(parent==".ly-loss"){
					var list="<tr class='gradeX'><td>"+time+"</td><td>"+data[i].channelNo+"</td><td>"+data[i].deviceDesc+"</td><td>"+data[i].floorNo+"</td></tr>"
				}else{
					var list='<li>'+
                                 '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']-['+data[i].staffno+']'+
                             
                            '</li>'
				}
				$(parent+" tbody").append(list);
			}
		}
	}

	// window.setInterval(function(){
	// 	var data={"battVol":3.9397,
	// 	"device":
	// 		{"channelNo":1,
	// 		 "deviceDesc":"Device1",
	// 		 "floorNo":0,"id":1},
	// 	"doorDistance":24,
	// 	"doorStatus":"Open",
	// 	"id":760,
	// 	"inputDt":1544457600000,
	// 	"isStaffCheck":"T",
	// 	"nbSignalPwr":-98.8,
	// 	"staffno":"",
	// 	"updateDt":1544510909031
	// }
	  
	//   var lyrealtrlength=$(".ly-real tbody tr").length;
	//   var lymantrlength=$(".ly-man tbody tr").length;
	//   var date=new Date(1544457600000);
	  
	//   date=date.toLocaleString().substring(date.toLocaleString().length-8);
	//   var list="<tr class='gradeX'><td>"+date+"</td><td>"+data.device.deviceDesc+"</td><td>"+data.doorStatus+"</td><td>"+data.nbSignalPwr+"</td><td>"+Number(data.battVol).toFixed(3)+"%</td></tr>"
	//   if(lyrealtrlength<7){
	//   	if(lyrealtrlength==0){
	//   		$(".ly-real tbody").append(list);
	//   	}else{
	//   		$(".ly-real tbody tr:eq(0)").before(list);
	//   	}
	//   }else{
	//   	$(".ly-real tbody tr:eq(6)").remove();
	//   	$(".ly-real tbody tr:eq(0)").before(list);
	//   }
	//   if(data.isStaffCheck=='T'){
	//   	data.device.floorNo=data.device.floorNo+Math.random();
	//   	var listlyman="<tr class='gradeX'><td>"+date+"</td><td>"+data.device.floorNo+"</td><td>"+data.device.deviceDesc+"</td><td>"+data.doorDistance+"</td><td>"+data.doorStatus+"</td><td>"+data.staffno+"</td></tr>"
	 	
	//  	if(lymantrlength<7){
	// 	  	if(lymantrlength==0){
	// 	  		$(".ly-man tbody").append(listlyman);
	// 	  	}else{
	// 	  		$(".ly-man tbody tr:eq(0)").before(listlyman);
	// 	  	}
	// 	  }else{
	// 	  	$(".ly-man tbody tr:eq(6)").remove();
	// 	  	$(".ly-man tbody tr:eq(0)").before(listlyman);
	// 	  }
	//   }
	// },4000)
	//websocket test
	//var ws = new WebSocket("ws://3.16.108.250:8080/eip-ishare/ws.do");
	var ws = new WebSocket("ws://18.191.197.106:8080/eip-ishare/ws.do");
//	var ws = new WebSocket("ws://127.0.0.1:8080/eip-ishare/ws.do");
	ws.onopen = function()

	{  console.log("open");

	  // ws.send();

	};

	ws.onmessage = function(evt)

	{

	  // console.log(evt.data)
	  var data=JSON.parse(evt.data);
	  var lyrealtrlength=$(".ly-real tbody tr").length;
	  var lymantrlength=$(".ly-man tbody tr").length;
	  var lyautotrlength=$(".ly-auto tbody tr").length;
	  var date=new Date(Number(data.inputDt));
	  date=date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	  var list="<tr class='gradeX'><td>"+date+"</td><td>"+data.device.deviceDesc+"</td><td>"+data.doorStatus+"</td><td>"+data.nbSignalPwr+"</td><td>"+Number(data.battVol).toFixed(3)+"%</td></tr>"
	  if(lyrealtrlength<7){
	  	if(lyrealtrlength==0){
	  		$(".ly-real tbody").append(list);
	  	}else{
	  		$(".ly-real tbody tr:eq(0)").before(list);
	  	}
	  }else{
	  	$(".ly-real tbody tr:eq(6)").remove();
	  	$(".ly-real tbody tr:eq(0)").before(list);
	  }
	  if(data.isStaffCheck=='T'){
	  	var listlyman="<tr class='gradeX'><td>"+date+"</td><td>"+data.device.floorNo+"</td><td>"+data.device.deviceDesc+"</td><td>"+data.doorDistance+"</td><td>"+data.doorStatus+"</td><td>"+data.staffno+"</td></tr>"
	 	
	 	if(lymantrlength<7){
		  	if(lymantrlength==0){
		  		$(".ly-man tbody").append(listlyman);
		  	}else{
		  		$(".ly-man tbody tr:eq(0)").before(listlyman);
		  	}
		  }else{
		  	$(".ly-man tbody tr:eq(6)").remove();
		  	$(".ly-man tbody tr:eq(0)").before(listlyman);
		  }
	  }else{
	  	var listlyauto="<tr class='gradeX'><td>"+date+"</td><td>"+data.device.channelNo+"</td><td>"+data.device.floorNo+"</td><td>"+data.device.deviceDesc+"</td><td>"+data.doorStatus+"</td></tr>"
	 	
	 	if(lyautotrlength<7){
		  	if(lyautotrlength==0){
		  		$(".ly-auto tbody").append(listlyauto);
		  	}else{
		  		$(".ly-auto tbody tr:eq(0)").before(listlyauto);
		  	}
		  }else{
		  	$(".ly-auto tbody tr:eq(6)").remove();
		  	$(".ly-auto tbody tr:eq(0)").before(listlyauto);
		  }
	  }
	  
	  //addDatatable(evt.data,".ly-real")

	};

	ws.onclose = function(evt)

	{

	  console.log("WebSocketClosed!");

	};

	ws.onerror = function(evt)

	{

	  console.log("WebSocketError!");

	};


//	var ws1 = new WebSocket("ws://3.16.108.250:8080/eip-ishare/deviceinfows.do");
	var ws1 = new WebSocket("ws://18.191.197.106:8080/eip-ishare/deviceinfows.do");
//	var ws1 = new WebSocket("ws://127.0.0.1:8080/eip-ishare/deviceinfows.do");

	ws1.onopen = function()

	{  console.log("open");

	  // ws.send();

	};
	// {"loss":
	 // 	[{
	 // 		"channelNo":1,
	 // 		"deviceDesc":"Device1",
	 // 		"floorNo":0,
	 // 		"id":1,
	 // 		"state":"1"
	 // 	 },
	 // 	 {"channelNo":1,
	 // 	  "deviceDesc":"Device2",
	 // 	   "floorNo":0,
	 // 	   "id":2,
	 // 	   "state":"1"
	 // 	 },{"channelNo":1,
	 // 	   "deviceDesc":"Device3",
	 // 	   "floorNo":0,
	 // 	    "id":3,
	 // 	    "state":"1"},
	 // 	  {"channelNo":2,
	 // 	   "deviceDesc":"Device4",
	 // 	   "floorNo":0,
	 // 	   "id":4,
	 // 	   "state":"1"},
	 // 	  {"channelNo":2,
	 // 	   "deviceDesc":"Device5",
	 // 	   "floorNo":0,
	 // 	   "id":5,
	 // 	   "state":"1"},
	 // 	  {"channelNo":3,
	 // 	   "deviceDesc":"Device6",
	 // 	   "floorNo":0,
	 // 	   "id":6,
	 // 	   "state":"1"
	 // 	}],"doorstatuscount":[]}
	ws1.onmessage = function(evt)

	{
	  // console.log(evt.data)
	  var data=JSON.parse(evt.data);
	  if(data.doorstatuscount.length!=0){
	  	close=Number(data.doorstatuscount[0].Close);
		open=Number(data.doorstatuscount[1].Open);
	  }else{
	  	open=0;
	  	close=0;
	  }
	  $(".ly-open").text(open);
	  $(".ly-close").text(close);
	  $(".ly-lose").text(all-open-close);
	  var time=data.inputDt.substring(data.inputDt.length-8)
	  data=data.loss;
	  $(".ly-loss tbody tr").remove();
	  for(var i=0;i<data.length;i++){
	  	  var list="<tr class='gradeX'><td>"+time+"</td><td>"+data[i].channelNo+"</td><td>"+data[i].floorNo+"</td><td>"+data[i].deviceDesc+"</td></tr>"
		  $(".ly-loss tbody").append(list);
	  }
	
	  //addDatatable(data,".ly-loss",time)
	 }

	ws1.onclose = function(evt)

	{

	  console.log("WebSocketClosed!");

	};

	ws1.onerror = function(evt)

	{

	  console.log("WebSocketError!");

	};

	//获取 close open loss all数据
	var close=0,open=0,all=0,loss=0;
	$.ajax({
		url:'/eip-ishare/device/getall.do',
		success:function(data){
			all=Number(data.total);
			$(".ly-all").text(data.total);

		}
	})
		
})