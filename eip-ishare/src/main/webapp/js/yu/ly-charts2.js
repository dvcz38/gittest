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
		var COLORS=["#4d886d","#4d886d","green","gray","blue"]
		//var deviceDesc=$(".doorDistance").find("option:selected").text();
		// var deviceId=$(".doorDistance").val();
		var deviceDesc=device[0].deviceDesc;
		var deviceId=device[0].deviceId;
		$(".doorDistance").change(function(){
			deviceDesc=$(".doorDistance").find("option:selected").text();
			deviceId=$(".doorDistance").val();
			
		})
		console.log(deviceId)
		
		function getAjaxPoint(series,color,name,chart,y){
			var x = (new Date()).getTime(), // 当前时间
				y = y;          // 随机值
				series.addPoint({x:x, y:y}, true, true);
				// series.name=name;
				var options = chart.series[0].options;
				series.update({color:color,name:name})
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
				type: 'column',
				marginRight: 10,
				backgroundColor:"#353535",
				events: {
					load: function () {
						var series = this.series[0],
							chart = this;
							console.log(chart)
						activeLastPointToolip(chart);
						setInterval(function () {
							// $.ajax({
							//  	url:"/eip-ishare/device/getdevice.do",
							//  	type:'post',
							//  	data:{'deviceId':deviceId},
							//  	success:function(data){
							//  		console.log(data)
							//  		if(data.rows.length!=0){
							//  			getAjaxPoint(series,COLORS[deviceId],deviceDesc,chart,data.rows[0].doorDistance)
							//  		}else{
							//  			getAjaxPoint(series,COLORS[deviceId],deviceDesc,chart,0)
							//  		}
							//  	}
							//  })
							getAjaxPoint(series,COLORS[deviceId],deviceDesc,chart,Math.random()*50+10)
							
						},1000);
					}
				}
			},
			title: {
				text: ''
			},
			
			xAxis: {
				type: 'datetime',
				tickPixelInterval: 150
			},
			yAxis: {
				title: {
					text: null
				}
			},
			tooltip: {
				formatter: function () {
					return '<b>' + this.series.name + '</b><br/>' +
						Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
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
						time = (new Date()).getTime(),
						i;
					for (i = -19; i <= 0; i += 1) {
						data.push({
							x: time + i * 1000,
							y:0
						});
					}

					return data;
				}())
			}]
		});
		

	}

	
})