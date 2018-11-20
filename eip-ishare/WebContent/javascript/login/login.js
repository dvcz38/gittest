/****************************************************************登录js****************************************************************/
$(function(){
	//登录按钮
	$("#login_btn").click(function(){
		
	var user_Name = $("#userId").val();
	var user_Pwd = $("#pswId").val();
	
	$("input[type='text']").each(function(){
		
		if($(this).val()==""){
			//获取属性的值(获取name对应的值)
			//$(this).attr("name")
			
			layer.alert(" "+$(this).attr("name")+"不能为空！\r\n", {
				  skin: 'layui-layer-molv', //样式类名 自定义样式
				  closeBtn: 1,  // 是否显示关闭按钮
				  anim: 1,//动画类型
				  icon: 6,  // icon
			});
		}else{
			
			$("input[type='password']").each(function(){
				
				if($(this).val()==""){
					
					layer.alert(" "+$(this).attr("name")+"不能为空！\r\n", {
						  skin: 'layui-layer-molv', //样式类名 自定义样式
						  closeBtn: 1,  // 是否显示关闭按钮
						  anim: 1,//动画类型
						  icon: 6,  // icon
					});
					
				}else{
					
					$.ajax({
						url: ctx+"/login/doLogin.do",
						type: 'post',
						data: {
								  user_Name:user_Name,
								  user_Pwd:user_Pwd
						      },
						 success: function(result) {
						        	
								   if(result.msg == 'success'){
								        		
									   window.location.href = ctx+'/index/main.do';  
								   }else{
									   
									   layer.alert("用户名或密码错误！\r\n", {
											  skin: 'layui-layer-molv', //样式类名 自定义样式
											  closeBtn: 1,  // 是否显示关闭按钮
											  anim: 1,//动画类型
											  icon: 6,  // icon
										});
								   }
						        	
						     	},error:function(result){
						        		
						     		 layer.alert("系统出错\r\n", {
										  skin: 'layui-layer-molv', //样式类名 自定义样式
										  closeBtn: 1,  // 是否显示关闭按钮
										  anim: 1,//动画类型
										  icon: 6,  // icon
								});
						    }
						});
					}
				
				});
			}
		});
	
	});
			
});
	
	
