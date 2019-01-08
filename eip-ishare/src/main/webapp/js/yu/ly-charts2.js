$(function(){
	//select device
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

		Highcharts.setOptions({
			global: {
				useUTC: false
			}
		});
		var COLORS=["#7cb5ec","#4d886d","green","gray","blue"]
		var deviceDesc=$(".doorDistance").find("option:selected").text();
		var deviceId=$(".doorDistance").find("option:selected").val();
		// var deviceDesc=device[0].deviceDesc;
		// var deviceId=device[0].deviceId;
		$(".doorDistance").change(function(){
			deviceDesc=$(".doorDistance").find("option:selected").text();
			deviceId=$(".doorDistance").find("option:selected").val();
			
		})
		console.log(deviceId)
		
		function getAjaxPoint(series,color,name,chart,y,time){
			//console.log(time)
			var x = time, // 当前时间
				y = y;          // 随机值
				series.addPoint({x:x, y:y}, true, true);
				// series.name=name;
				var options = chart.series[0].options;
				series.update({name:name,color:color})//color
				options.animation=true;
				activeLastPointToolip(chart);
		}
		function activeLastPointToolip(chart) {
			var points = chart.series[0].points;

			chart.tooltip.refresh(points[points.length -1]);

		}
		Highcharts.setOptions({
			global: {
				useUTC: false
			},
			credits: {
			     enabled: false
			}
		});
		var chart1 = Highcharts.chart('ly-chart2', {
			chart: {
				type: 'areaspline',
				marginRight: 10,
				backgroundColor:"#353535",
				events: {
					load: function () {
						var series = this.series[0],
							chart = this;
							console.log(chart)
						activeLastPointToolip(chart);
						
						var ws = new WebSocket("ws://18.191.197.106:8080/eip-ishare/ws.do");

						ws.onopen = function()

						{  console.log("open");

						  // ws.send();

						};

						ws.onmessage = function(evt){
							var data=JSON.parse(evt.data);
							//console.log(data)
							var time=new Date(data.inputDt);
							time=time.getHours()+":"+time.getMinutes()+":"+time.getSeconds()

							if(Number(deviceId)==Number(data.device.id)){
								// console.log(deviceId)
								// console.log(data.device.id)
								console.log(data.doorDistance)
								getAjaxPoint(series,COLORS[deviceId],deviceDesc,chart,data.doorDistance,time)
								//getAjaxPoint(series,deviceDesc,chart,data.doorDistance,time)
							}else{
								getAjaxPoint(series,COLORS[deviceId],deviceDesc,chart,0,time)
								//getAjaxPoint(series,deviceDesc,chart,0,time)
							}
							
						}
							
					}
				}
			},
			title: {
				text: ''
			},
			
			xAxis: {
				type: 'datetime',
				tickPixelInterval: 150

				// tickInterval: 3600 * 1000,
    //                 //格式化时间，day,week....
    //              dateTimeLabelFormats: {
    //                    day: '%Y-%m-%d'
    //              }
			},
			yAxis: {
				title: {
					text: null
				}
			},
			tooltip: {
				formatter: function () {
					return '<b>' + this.series.name + '</b><br/>' +
					//%Y-%m-%d
						Highcharts.dateFormat('%H:%M:%S', this.x) + '<br/>' +
						Highcharts.numberFormat(this.y, 2);
				}
			},
			legend: {
				enabled:false
			},
			
			series: [{
				name: 'Devices 1',
				data: (function () {
					// 生成随机值
					var data = [],
						time =0,
						i;
					for (i = -19; i <= 0; i += 1) {
						data.push({
							x: time + i * 1000,
							y:i
						});
					}

					return data;
				}())
			}]
		});
		

	}

	
})