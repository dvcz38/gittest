/********************************************************动态菜单****************************************************************/
var treeLists = new Array();
var $menu_dialog_updatePwd;
$(function(){
	
	//前台 树型菜拼接
	$('#tree').tree({    
	    url:ctx+'/menu/find.do',    
	    loadFilter: function(data){ 
        	console.log(data);
        	for (var i=0;i<data.length;i++) {
        		var childrens = new Array();
        		var treeMenu={};         //父结点对象
        	    treeMenu.id = data[i].menuId;
        		treeMenu.text = data[i].menuCode;
        		var secCodes = data[i].secCodes;
				for(var j=0;j<secCodes.length;j++){
					var children={};     //子结点对象
					var attributes={};
					children.id = secCodes[j].secId;
					children.text = secCodes[j].secCode;
					children.iconCls = secCodes[j].secIcon;
					attributes.url = ctx+secCodes[j].url;    //拼接后台url controller
					children.attributes=attributes;
					childrens.push(children);
				}
				treeMenu.children = childrens;
				treeLists.push(treeMenu);
			}
        	console.log(treeLists);
        	return treeLists;
        	
	    }, onClick:function(node){                      //节点的点击事件  
	    	
            tab(node.text,node.attributes.url); 
           
       }
      
	});
 

	$('#centerDiv').tabs({
			fit : true,
			border : false,
			onContextMenu : function(e, title) {
				e.preventDefault();
				tabsMenu.menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data('tabTitle', title);
			}
	});
	
	//*******************************************//
	$("#menus").menubutton({
		menu:'#menu',
	});	
	$("#menus2").menubutton({
		menu:'#menu2',
	});
	
	$("#exitMenus").bind('click',function(){
		
		window.location.href = 'servlet/sessionServlet';
	});
	
});

//***************************************选项卡****************************************************//
function tab(text,url) {  
    if ($("#centerDiv").tabs('exists', text)) {   //若选项卡已存在，选择该选项卡  
        $("#centerDiv").tabs('select', text);  
    } else {  
        var content = "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="  
                + url + "></iframe>";     
          
        $("#centerDiv").tabs('add', {   //生成新的选项卡，  
            title : text,  
            closable : true,  
            content :content,  

        });  
    }  
}


	var teme;
	function changeTheme(themeName){ 
		teme=themeName;
		// var newUrl="${ pageContext.request.contextPath}"+urlView;
		
	    var themeCSS = $("#easyuiTheme");  //获取link对象
	    var url = themeCSS.attr('href');  //给对象赋值
	    var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';  
	    themeCSS.attr('href', href);  
	    var iframe = $('iframe');  
	    if(iframe.length > 0){  
	        for(var i = 0; i < iframe.length; i++){  
	            var ifr = iframe[i];  
	            $(ifr).contents().find('#easyuiTheme').attr('href', href);  
	        }  
	    }  
	 
	    $.cookie('easyuiThemeName', themeName,{  
	             //记住cookie的天数  
	             expires: 7 ,
	             //path:newUrl
	    });  
	    
	}  
	  
	if($.cookie('easyuiThemeName')){  
		
		//alert($.cookie('easyuiThemeName'));
	    changeTheme($.cookie('easyuiThemeName'));
	}
	
	
	
	var urlView;
	//我们使用 'exists' 方法来判断 tab 是否已经存在，如果已存在则激活 tab。如果不存在则调用 'add' 方法来添加一个新的 tab 面板。
	function addTab(title,url){
		//alert("url传值"+teme);
		
		if (typeof(teme)=="undefined") {
			
			teme="default";
		}
		
		var strUrl="${pageContext.request.contextPath}"+url+"?temeName="+teme;
		
		
		urlView=url;
		
		if($("#centerDiv").tabs('exists',title)){
			//存在则激活
			$("#centerDiv").tabs('select',title);
		}
		else{
			
			//alert(strUrl);
			//不存在 则添加一个面板
			var content = '<iframe scrolling="auto" frameborder="0"  src="'+strUrl+'" style="width:100%;height:100%;"></iframe>';
			$('#centerDiv').tabs('add',{
				title:title,
				content:content,
				closable:true
			});
		}
	}
	
	function updatePwd(){
		$menu_dialog_updatePwd = $("#menu_dialog_updatePwd").dialog({
    		title:'change password',
    		width:30%,
    		height:50%,
    		href:'#update_Menu',
    		
    		buttons:[{
    			text:'save',
    			iconCls: 'icon-add',
    			 handler: function () {
    				 test1AliPayDialog.dialog('close');
	             }
    		},{
    			text:'cancel',
    			iconCls: 'icon-cancel',
    			 handler: function () {
    				 test1AliPayDialog.dialog('close');
	             }
    		}]
    	});
	}
	

