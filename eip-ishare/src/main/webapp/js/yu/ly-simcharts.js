$(function(){
		Highcharts.setOptions({
		chart: {
			backgroundColor: '#353535'
		},
		global: {
			useUTC: false
		},

		credits: {
		    enabled:false
		}
	});
var sim=Highcharts.chart('ly-simcharts', {
	chart: {
		type: 'solidgauge',
		marginTop: 50,
		backgroundColor:"#353535"
	},
	title: {
		text: 'Sim Card:679M',
		style: {
			fontSize: '16px',
			color:"white"
		}
	},
	tooltip: {
		borderWidth: 0,
		backgroundColor: 'none',
		shadow: false,
		style: {
			fontSize: '16px',
			color:"white"
		}
		// ,
		// pointFormat: '{series.name}<br><span style="font-size:2em; color: {point.color}; font-weight: bold;margin-left:60px;">{point.y}%</span>',
		// positioner: function (labelWidth) {
		// 	return {
		// 		x: 280 - labelWidth / 2,
		// 		y: 140
		// 	};
		// }
	},
	pane: {
		startAngle: 0,
		endAngle: 360,
		background: [{ // Track for Move
			outerRadius: '112%',
			innerRadius: '88%',
			backgroundColor: '#4d886d',
			//Highcharts.Color(Highcharts.getOptions().colors[1]).setOpacity(0.3).get(),
			borderWidth: 0
		}, ]
	},
	yAxis: {
		min: 0,
		max: 100,
		lineWidth: 0,
		tickPositions: []
	},
	plotOptions: {
		solidgauge: {
			borderWidth: '24px',
			dataLabels: {
				enabled: false
			},
			linecap: 'round',
			stickyTracking: false
		}
	},
	series: [{
		name: 'sim card',
		// borderColor: Highcharts.getOptions().colors[1],
		borderColor:'#ecc11b',
		data: [{
			color: Highcharts.getOptions().colors[0],
			// color:'yellow',
			radius: '100%',
			innerRadius: '100%',
			y: 80
		}]
	}]
},
				 /**
     * In the chart load callback, add icons on top of the circular shapes
     */
				 function callback() {
	// Move icon
	// this.renderer.path(['M', -8, 0, 'L', 8, 0, 'M', 0, -8, 'L', 8, 0, 0, 8])
	// 	.attr({
	// 	'stroke': '#303030',
	// 	'stroke-linecap': 'round',
	// 	'stroke-linejoin': 'round',
	// 	'stroke-width': 2,
	// 	'zIndex': 10
	// })
	// 	.translate(190, 26)
	// 	.add(this.series[2].group);
	// Exercise icon
	
	});
})