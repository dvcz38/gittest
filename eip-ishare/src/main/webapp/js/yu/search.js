$(function(){
	//时间选择器
	for(var i=0;i<24;i++){
		if(i<10){
			var hourlist="<option>0"+i+"</option>";
		}else{
			var hourlist="<option>"+i+"</option>";
		}
		$(".start-hour").append(hourlist);
		$(".end-hour").append(hourlist);
	}
	for(var w=0;w<60;w++){
		if(w<10){
			var minseclist="<option>0"+w+"</option>";
		}else{
			var minseclist="<option>"+w+"</option>";
		}
		$(".start-min").append(minseclist);
		$(".end-min").append(minseclist);
	}

	$(".ly-search").click(function(){
		var day=$("#laydateInput").val();
		day=day.split("-");
		for(var i=0;i<day.length;i++){
			day[i]=day[i].trim();
		}
		if(Number(day[2])<10){
			day[2]="0"+day[2]
		}
		day=day[0]+"-"+day[1]+"-"+day[2];
		console.log(day)
		//初始时间要比结束时间大
		if(parseInt($(".start-hour").val())<parseInt($(".end-hour").val())){
		}else if(parseInt($(".start-hour").val())==parseInt($(".end-hour").val())){
			if(parseInt($(".start-min").val())<parseInt($(".end-min").val())){

			}else{
				alert("请选择正确的时间")
				return;
			}
			
		}else{
			alert("请选择正确的时间")
			return;
		}
		var starttime=day+" "+$(".start-hour").val()+":"+$(".start-min").val()+":00";
		var endtime=day+" "+$(".end-hour").val()+":"+$(".end-min").val()+":00";

		var data={"deviceId":$(".ly-select-device select").val(),"fdate":starttime,"todate":endtime};
		console.log(data);
		$.ajax({
			url:'/eip-ishare/device/dtl/search.do',
			data:data,
			type:'post',
			success:function(data){
				var data=JSON.parse(data);
				// var test={"total":1,
				// 	"rows":
				// 		[
				// 			{"id":2,"
				// 			 device":{
				// 			 	"id":2,
				// 			 	"deviceDesc":"Device2",
				// 			 	"floorNo":2,
				// 			 	"channelNo":1,
				// 			 	"state":"1",
				// 			 	"instalDt":null},
				// 			"nbSignalPwr":-98.3,
				// 			"doorDistance":0,
				// 			"doorStatus":"Close",
				// 			"isStaffCheck":"F",
				// 			"staffno":"staff002",
				// 			"battVol":4.03315,
				// 			"inputDt":"2018-11-27 01:00:00",
				// 			"updateDt":"2018-11-14 04:23:00"}
				// 		]
				// }
				$("table tbody tr").remove();
				for(var i=0;i<data.rows.length;i++){
					var list="<tr class='gradeX'><td>"+data.rows[i].inputDt.substring(data.rows[i].inputDt.length-8)+"</td><td>"+data.rows[i].device.deviceDesc+"</td><td>"+data.rows[i].doorStatus+"</td><td>"+data.rows[i].nbSignalPwr+"</td><td>"+Number(data.rows[i].battVol).toFixed(2)+"%</td></tr>"
					$("table tbody tr").append(list)
				}
			}
		})
	})

	var device=[];

	$.ajax({
		url:'/eip-ishare/device/getall.do',
		success:function(data){
			console.log(data)
			for(var i=0;i<data.rows.length;i++){
				device.push({"deviceId":data.rows[i].id,"deviceDesc":data.rows[i].deviceDesc})
			}
			console.log(device)
			
			addDeviceSelect(device,".ly-select-device select");
		}
	})


	function addDeviceSelect(data,parent){
		for(var i=0;i<data.length;i++){
			var option='<option value='+data[i].deviceId+'>'+data[i].deviceDesc+'</option>'
			$(parent).append(option);
		}
	}
	$(".ly-select-device select").change(function(){
		deviceDesc=$(".ly-select-device select").find("option:selected").text();
		deviceId=$(".ly-select-device select").val();
			
	})
})