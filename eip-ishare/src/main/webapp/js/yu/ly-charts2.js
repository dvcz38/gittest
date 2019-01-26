$(function(){
		//select device
		// var data=[{
		// 		"battVol":4.12983,
		// 		"device":
		// 			{"channelNo":1,
		// 			 "deviceDesc":"Device6",
		// 			 "floorNo":0,"id":"6"},
		// 		"doorDistance":23,
		// 		"doorStatus":"Open",
		// 		"id":1848,
		// 		"inputDt":1547607696000,
		// 		"isStaffCheck":"F",
		// 		"nbSignalPwr":693.0,
		// 		"updateDt":1547629486947}
		// 		]
		
		deviceDesc=0;
		deviceId=0;
		

		var device=[];
		$.ajax({
			url:'/eip-ishare/device/getall.do',
			success:function(data){
				console.log(data)
				for(var i=0;i<data.rows.length;i++){
					device.push({"deviceId":data.rows[i].id,"deviceDesc":data.rows[i].deviceDesc})
				}
				console.log(device)
				
				addDeviceSelect(device,".doorDistance");
			}
		})
		function addDeviceSelect(data,parent){
			for(var i=0;i<data.length;i++){
				var option='<option value='+data[i].deviceId+'>'+data[i].deviceDesc+'</option>'
				$(parent).append(option);
			}
			
			deviceDesc=$(".doorDistance").find("option:selected").text();
			deviceId=$(".doorDistance").val();
			ws = new WebSocket("ws://18.191.197.106:8080/eip-ishare/deviceinfo.do/"+deviceId); 
			ws.onopen = function(){  
				console.log("open doorsensor");
				// var messageObj = {'id':3};
				// var messageJson = JSON.stringify(messageObj);
				//ws.send(messageJson);
						    

			};

			ws.onmessage = function(evt){
				
				data=JSON.parse(evt.data);
				console.log(evt.data)
				data=data.record;
				var sdata=[];
				var xdata=[];
				for(var i=0;i<data.length;i++){
					var date=new Date(Number(data[i].inputDt));
					//sdata.push({x:Number(data[i].doorDistance),y:Number(date.getHours()),z:Number(date.getMinutes()),w:Number(date.getSeconds())})
			 		date=date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
			 		console.log(data.inputDt)
			 		
					sdata.push(Number(data[i].doorDistance))
					xdata.push(date)
				}
				var chart = Highcharts.chart('ly-chart2', {
							chart:{
									animation: false,
									backgroundColor:"white",
									type:"column"
								}, 
							legend: {
								layout: 'vertical',
								align: 'right',
								verticalAlign: 'middle',
								enabled:false
							},

							xAxis: {
								categories:xdata,
					            tickmarkPlacement : 'on',// 在刻度上显示时间而不是在刻度之间显示时间
					            tickInterval :600// 每隔12个刻度显示一个刻度，不显示的刻度依旧存在，只是不显示
					              
					        },
					        tooltip: {
								formatter: function () {
									// return '<b>' + this.series.name + '</b><br/>' +
									// 	Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
									// 	Highcharts.numberFormat(this.y, 2);
									return '<b>' + deviceDesc + '</b><br/>' + 
									    this.x + '<br/>' +
										this.y
								}
							},
						    plotOptions: {
								series: {
									label: {
										connectorAllowed: false
									},
									marker:{
										radius:0.1
									},
									animation: false 
									// pointStart: 2010
									}
							},
							series: [{
								data:sdata,
								name:deviceDesc
							}]
				})	
											
			}
		}
		var wsarr=[];
		$(".doorDistance").change(function(){
			deviceDesc=$(".doorDistance").find("option:selected").text();
			deviceId=$(".doorDistance").val();
			console.log(deviceId)
			
			

			
			wsarr.push(new WebSocket("ws://18.191.197.106:8080/eip-ishare/deviceinfo.do/"+deviceId)); 

		wsarr[wsarr.length-1].onopen = function()

			{  console.log("open doorsensor");
				console.log(wsarr)
				ws.close();
				for(var i=0;i<wsarr.length-1;i++){
					console.log("i："+i)
					wsarr[i].close()
				}
				// var messageObj = {'id':3};
				// var messageJson = JSON.stringify(messageObj);
				// ws.send(messageJson);
						    

			};

			wsarr[wsarr.length-1].onmessage = function(evt){
				var sdata=[];
				var xdata=[];
				data=JSON.parse(evt.data);
				
				data=data.record;
				console.log("doorDistance："+data[0].doorDistance)
				for(var i=0;i<data.length;i++){
					var date=new Date(Number(data[i].inputDt));
					//sdata.push({x:Number(data[i].doorDistance),y:Number(date.getHours()),z:Number(date.getMinutes()),w:Number(date.getSeconds())})
			 		date=date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
			 		console.log(data.inputDt)
			 		sdata.push(Number(data[i].doorDistance))
			 		xdata.push(date)
				}
				var chart = Highcharts.chart('ly-chart2', {
							chart:{
									animation: false,
									backgroundColor:"white",
									type:"column"
								}, 
							legend: {
								layout: 'vertical',
								align: 'right',
								verticalAlign: 'middle',
								enabled:false
							},

							xAxis: {
								categories:xdata,
					            tickmarkPlacement : 'on',// 在刻度上显示时间而不是在刻度之间显示时间
					            tickInterval :360// 每隔12个刻度显示一个刻度，不显示的刻度依旧存在，只是不显示
					              
					        },
					        tooltip: {
								formatter: function () {
									// return '<b>' + this.series.name + '</b><br/>' +
									// 	Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
									// 	Highcharts.numberFormat(this.y, 2);
									return '<b>' + deviceDesc + '</b><br/>' + 
									    this.x + '<br/>' +
										this.y
								}
							},
						    plotOptions: {
								series: {
									label: {
										connectorAllowed: false
									},
									marker:{
										radius:0.1
									},
									animation: false 
									// pointStart: 2010
									}
							},
							series: [{
								data:sdata,
								name:deviceDesc
							}]
				})	
											
			}
			
		})
		console.log(deviceId)
		
		
		Highcharts.setOptions({
			global: {
				useUTC: false
			},
			credits: {
			     enabled: false
			}
		});
		
		
		// window.setInterval(function(){
		// 	for(var i=0;i<data.length;i++){
		// 		var date=new Date(Number(data[i].inputDt));
		//  		date=date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		// 		sdata.push(Number(data[i].doorDistance)+Math.random())
		// 		xdata.push(date)
		// 	}
		// 	var chart = Highcharts.chart('ly-chart2', {
		// 				chart:{
		// 						animation: false,
		// 						backgroundColor:"#353535"
		// 					}, 
		// 				legend: {
		// 					layout: 'vertical',
		// 					align: 'right',
		// 					verticalAlign: 'middle',
		// 					enabled:false
		// 				},

		// 				xAxis: {
		// 					categories:xdata,
		// 		            tickmarkPlacement : 'on',// 在刻度上显示时间而不是在刻度之间显示时间
		// 		            tickInterval :60// 每隔12个刻度显示一个刻度，不显示的刻度依旧存在，只是不显示
				              
		// 		        },
		// 		        tooltip: {
		// 					formatter: function () {
		// 						return '<b>' + this.series.name + '</b><br/>' +
		// 							Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
		// 							Highcharts.numberFormat(this.y, 2);
		// 					}
		// 				},
		// 			    plotOptions: {
		// 					series: {
		// 						label: {
		// 							connectorAllowed: false
		// 						},
		// 						marker:{
		// 							radius:0.1
		// 						},
		// 						animation: false 
		// 						// pointStart: 2010
		// 						}
		// 				},
		// 				series: [{
		// 					data:sdata,
		// 					name:"Devices 1"
		// 				}]
		// 	})
		// },1000)
})





		// function getAjaxPoint(series,color,name,chart,y){
		// 	console.log("point")
		// 	var x = (new Date()).getTime(), // 当前时间
		// 		y = y;          // 随机值
		// 		series.addPoint({x:x, y:y}, true, true);
		// 		// series.name=name;
		// 		var options = chart.series[0].options;
		// 		series.update({color:color,name:name})
		// 		options.animation=true;
		// 		activeLastPointToolip(chart);
		// }
		// function activeLastPointToolip(chart) {
		// 	var points = chart.series[0].points;

		// 	chart.tooltip.refresh(points[points.length -1]);

		// }
// 		var chart1 = Highcharts.chart('ly-chart2', {
// 			chart: {
// 				type: 'areaspline',
// 				marginRight: 10,
// 				backgroundColor:"#353535",
// 				events: {
// 					load: function () {
// 						var series = this.series[0],
// 							chart = this;
// 							console.log(chart)
// 						activeLastPointToolip(chart);
// 						ws = new WebSocket("ws://18.191.197.106:8080/eip-ishare/doorsensor.do"); 
// 						//var ws = new WebSocket("ws://18.191.197.106:8080/eip-ishare/ws.do");
// //						var ws = new WebSocket("ws://3.16.108.250:8080/eip-ishare/ws.do");

// 						ws.onopen = function()

// 						{  console.log("open");
// 							var messageObj = {'id':3};
// 							var messageJson = JSON.stringify(messageObj);
// 							ws.send(messageJson);
						    

// 						};

// 						ws.onmessage = function(evt){
// 							console.log(evt)
// 							var data=JSON.parse(evt.data);
// 							console.log(data)
// 							if(deviceId==data.device.id){
// 								getAjaxPoint(series,COLORS[deviceId],deviceDesc,chart,data.nbSignalPwr)
// 							}else{
// 								getAjaxPoint(series,COLORS[deviceId],deviceDesc,chart,0)
// 							}
							
// 						}
							
// 					}
// 				}
// 			},
// 			title: {
// 				text: ''
// 			},
			
// 			xAxis: {
// 				type: 'datetime',
// 				tickPixelInterval: 150
// 			},
// 			yAxis: {
// 				title: {
// 					text: null
// 				}
// 			},
// 			tooltip: {
// 				formatter: function () {
// 					return '<b>' + this.series.name + '</b><br/>' +
// 						Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
// 						Highcharts.numberFormat(this.y, 2);
// 				}
// 			},
// 			legend: {
// 				enabled:false
// 			},
			
// 			series: [{
// 				name: 'Devices 1',
// 				data: (function () {
// 					// 生成随机值
// 					var data = [],
// 						time = (new Date()).getTime(),
// 						i;
// 					for (i = -19; i <= 0; i += 1) {
// 						data.push({
// 							x: time + i * 1000,
// 							y:0
// 						});
// 					}

// 					return data;
// 				}())
// 			}]
// 		});
		

// 	}