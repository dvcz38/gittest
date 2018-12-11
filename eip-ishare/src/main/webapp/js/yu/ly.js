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
	// window.setInterval(function(){
	// 	$.ajax({
	// 		url:'/eip-ishare/device/findautocheck.do',
	// 		success:function(data){
	// 			if(data.rows.length!=0){
	// 				addDataList(data,".ly-auto");
	// 			}
				
	// 		}
	// 	})
	// 	$.ajax({
	// 		url:'/eip-ishare/device/findmanulcheck.do',
	// 		success:function(data){
	// 			if(data.rows.length!=0){
	// 				addDataList(data,".ly-human");
	// 			}
	// 		}
	// 	})

	// },1000)
	


	//获取 close open loss all数据
	// var close=0,open=0,all=0,loss=0;
	// window.setInterval(function(){
	// 	$.ajax({
	// 		url:'/eip-ishare/device/getall.do',
	// 		success:function(data){
	// 			all=data.total;
	// 			$(".ly-all").text(data.total);
	// 			loss=Number(all)-Number(open)-Number(close);
	// 			$(".ly-lose").text(loss);

	// 		}
	// 	})
	// 	$.ajax({
	// 		url:'/eip-ishare/device/getopenclose.do',
	// 		success:function(data){
	// 			if(data.rows.length==0){
	// 				open=0;
	// 				close=0;	
	// 			}else{
	// 				open=data.rows[0].open;
	// 				close=data.rows[0].close;
	// 			}
	// 			$(".ly-open").text(open);
	// 			$(".ly-close").text(close);
	// 			loss=Number(all)-Number(open)-Number(close);
	// 			$(".ly-lose").text(loss);
	// 		}
	// 	})
		
		
	// },1000)
	
	// window.setInterval(function(){
	// 	//获得通道
	// 	$.ajax({
	// 		url:'/eip-ishare/device/getchanel.do',
	// 		success:function(data){
	// 			if(data.rows.length!=0){
	// 				if($(".ly-channel").find("span").length!=0){
	// 					$(".ly-channel").find("span").remove();
	// 				}
	// 				for(var i=0;i<data.rows.length;i++){
	// 					var span= '<span class=" mws-ic ic-bullet_star ly-bullet_star">Channel '+data.rows[i].channelNo+'</span>'
	// 					$(".ly-channel").append(span)
	// 				}
	// 			}
	// 		}
	// 	})
	// },1000)
	
	var maxtableLength=7;
	function addDatatable(data,parent){
		// var data=data.rows;
		var data=data;
		console.log(data[0].inputDt)
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
				if(parent==".ly-real"){
					var list="<tr class='gradeX'><td>1</td><td>1</td><td>1</td><td>"+data[i].channelNo+"</td><td>"+data[i].floorNo+"</td></tr>"
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
				if(parent==".ly-real"){
					var list="<tr class='gradeX'><td>1</td><td>1</td><td>1</td><td>"+data[i].channelNo+"</td><td>"+data[i].floorNo+"</td></tr>"
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
				console.log($(".ly-auto li:eq("+z+")"))
				
				$(parent+" tbody tr:eq("+temp+")").remove()

			}
			for(var i=0;i<dataLength;i++){
				
				// if(data[i].doorStatus=="Close"){
				// 	iconclass="ic-bullet-green"
				// }else{
				// 	iconclass="ic-bullet-red"
				// }
				// data[i].inputDt=data[i].inputDt.substring(data[i].inputDt.length-8);
				if(parent==".ly-real"){
					var list="<tr class='gradeX'><td>1</td><td>1</td><td>1</td><td>"+data[i].channelNo+"</td><td>"+data[i].floorNo+"</td></tr>"
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
				if(parent==".ly-real"){
					var list="<tr class='gradeX'><td>1</td><td>1</td><td>1</td><td>"+data[i].channelNo+"</td><td>"+data[i].floorNo+"</td></tr>"
				}else{
					var list='<li>'+
                                 '<span style="width:20px;height:20px;background-size:100% 100%;" class="mws-report-icon mws-ic '+iconclass+'"></span><span>'+data[i].inputDt+'</span>  [Channel '+ data[i].device.channelNo+']-[Floor '+data[i].device.floorNo+']-['+data[i].device.deviceDesc+']-[Battery Vol:'+(Number(data[i].battVol).toFixed(2))+"%"+']-[Door '+data[i].doorStatus+']-['+data[i].staffno+']'+
                             
                            '</li>'
				}
				$(parent+" tbody").append(list);
			}
		}
	}

	//websocket test
	// var ws = new WebSocket("ws://3.16.108.250:8080/eip-ishare/ws.do");

	// ws.onopen = function()

	// {  console.log("open");

	//   // ws.send();

	// };

	// ws.onmessage = function(evt)

	// {

	//   console.log(evt.data)
	//   addDatatable(evt.data,".ly-real")

	// };

	// ws.onclose = function(evt)

	// {

	//   console.log("WebSocketClosed!");

	// };

	// ws.onerror = function(evt)

	// {

	//   console.log("WebSocketError!");

	// };
})
