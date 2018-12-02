$(function(){
	var dom = document.getElementById("container");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
		title:{
			text:"data",
			textStyle:{
				color:"white"
			}
		},
		tooltip : {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross',
	            label: {
	                backgroundColor: '#6a7985'
	            }
	        }
	    },
	    legend: {
	        data:['one','two','three'],
	        textStyle:{
	        	color:"white"
	        }
	    },
	    xAxis: {
	        type: 'category',
	        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
	        axisLine:{
                lineStyle :{
                                color: '#CECECE'
                            }
                }


	   		 },
	    yAxis: {
	        type: 'value',
	         axisLine:{
                lineStyle :{
                                color: '#CECECE'
                            }
                }
	    },
	    series: [{
	    	name:'one',
	        data: [120, 932, 501, 734, 1290, 1630, 1020],
	        type: 'line',
	        color:['#66AEDE'],
	    },{
	    	name:'two',
	        data: [320, 932, 401, 934, 1200, 1330, 1320],
	        type: 'line'
	    },{
	    	name:'three',
	        data: [420, 832, 901, 134, 1290, 130, 1120],
	        type: 'line'
	    }]
	};
	;
	if (option && typeof option === "object") {
	    myChart.setOption(option, true);
	}


	//设备数量 部分代码
	// $.ajax('url',success:function(data){
	// 	$(".blue b").text(data.all);
	// 	$(".greem b").text(data.all);
	// 	$(".red b").text(data.all);
	// 	$(".gray b").text(data.all);
	// })


	//自动巡检 部分代码
	// var maxLength=6;
	// $.ajax("url",success:function(data){
	// 	if($(".aut .block-list")){
	// 		var divLength=$(".aut .block-list").length;
	// 	}else{
	// 		var divLength=0;
	// 	}
	// 	var dataLength=data.length;
	// 	var fa;
	// 	if(dataLength>=maxLength){//数据超过显示的条数 直接倒叙放入既可
	// 		//清除现有的条目
	// 		$(".aut .block-list").remove();
	// 		for(var i=dataLength-1;i>=dataLength-maxLength;i--){
	// 			if(data[i].state==1){//根据设备状态 设置i的样式
	// 				fa=".green";
	// 			}else if(data[i].state==2){
	// 				fa=".red";
	// 			}else{
	// 				fa=".gray";
	// 			}
	// 			var list='<div class="block-list"><i class="fa fa-circle-o '+fa+'"></i>20:15-1/301-deviceone-20%-state</div>'
	// 			$(".auto").append(list);
	// 		}
	// 	}else if(dataLength+divLength<maxLength&&divLength!=0){
	// 		for(var j=dataLength-1;j>=0;j--){
	// 			if(data[j].state==1){//根据设备状态 设置i的样式
	// 				fa=".green";
	// 			}else if(data[j].state==2){
	// 				fa=".red";
	// 			}else{
	// 				fa=".gray";
	// 			}
	// 			var list='<div class="block-list"><i class="fa fa-circle-o '+fa+'"></i>20:15-1/301-deviceone-20%-state</div>'
	// 			$(".auto .block-time").after(list);
	// 		}
	// 	}else if(dataLength+divLength>maxLength&&divLength!=0&&dataLength<maxLength){
	// 		var delLength=(dataLength+divLength)-maxLength;
	// 		for(var z=0;z<delLength;z++){
	// 			$(".aut .block-list:eq("+divLength-1-z+")").remove()
	// 		}
	// 		for(var k=dataLength-1;k>=0;k--){
	// 			if(data[k].state==1){//根据设备状态 设置i的样式
	// 				fa=".green";
	// 			}else if(data[k].state==2){
	// 				fa=".red";
	// 			}else{
	// 				fa=".gray";
	// 			}
	// 			var list='<div class="block-list"><i class="fa fa-circle-o '+fa+'"></i>20:15-1/301-deviceone-20%-state</div>'
	// 			$(".auto .block-time").after(list);
	// 		}
	// 	}else if(divLength==0){
	// 		for(var w=dataLength-1;w>=dataLength-maxLength<=0?0:dataLength-maxLength;w--){
	// 			if(data[w].state==1){//根据设备状态 设置i的样式
	// 				fa=".green";
	// 			}else if(data[w].state==2){
	// 				fa=".red";
	// 			}else{
	// 				fa=".gray";
	// 			}
	// 			var list='<div class="block-list"><i class="fa fa-circle-o '+fa+'"></i>20:15-1/301-deviceone-20%-state</div>'
	// 			$(".auto").append(list);
	// 		}
	// 	}
	// })

	//设置当前日期
	var date=new Date();
	var monthEng=['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sept','Oct','Nov','Dec'];
	var month=monthEng[date.getMonth()];
	var day=date.getDate();
	var year=date.getFullYear();
	$(".block-time").text(month+" "+day+"th  "+year)
})