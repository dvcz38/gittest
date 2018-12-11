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
		var starttime=day+"-"+$(".start-hour").val()+":"+$(".start-min").val()+":00";
		var endtime=day+"-"+$(".end-hour").val()+":"+$(".end-min").val()+":00";

		var data={"id":"1","fdate":starttime,"todate":endtime};
		// $.ajax({
		// 	url:'/eip-ishare/device/search.do',
		// 	data:data,
		// 	type:'post',
		// 	success:function(data){

		// 	}
		// })
	})
})