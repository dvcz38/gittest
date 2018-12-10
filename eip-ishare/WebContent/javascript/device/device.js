var userInfoManage_pagination;
var userInfoManage_datagrid;

$(function(){
	 
    $('#updateUser').dialog('close');
    $('#addUser').dialog('close');
	
	 
	userInfoManage_datagrid = $("#userInfoManage_datagrid").datagrid({
		  url:ctx+"/device/getall.do",
 
		  striped: true,
		  fit: true,          
		  singleSelect: false, 
		  pagination: true,  
		  rownumbers: true, 
		  frozenColumns:
			  [[
                {field : 'ck',checkbox : true},
//                {width: '70',title: 'ID',field: 'id'},
                {width: '70',title: 'Device ID',field: 'id'},    
                { width: '100',title: 'Device Name',field: 'deviceDesc'}
    
		      ]],
		  columns:[[
//				{width: '100',title: 'Date Time',field: 'inputDt',sortable: true},     
				{width: '100',title: 'Channel Number',field: 'channelNo'}, 
	          	{width: '100',title: 'Floor',field: 'floorNo'},    
	          	{width: '100',title: 'State',field: 'state'},  
	          	{width: '100',title: 'Install Date',field: 'instalDt'} 
	      ]],toolbar:

	    	  [{ iconCls: 'icon-add',
                  text:'Add',
                  handler: function(){
                    	$('#addUser').dialog('open'); 
                    } 
               
	    	  },'-',{
                iconCls: 'icon-edit',
                text:'Edit',
                handler: function(){
                    var stus = $("#userInfoManage_datagrid").datagrid('getSelections');
                    
                    if (stus.length != 1) {
                        $.messager.confirm('Information', 'Please select one item!', function(r){
                
                                $("#userInfoManage_datagrid").datagrid('unselectAll');
                            
                        })
                    } else {
                         
                        $('#updateUser').dialog('open');
                       
                       var stu = stus[0];
                        $('#upUserForm').form('load',stu);                               
              
                    }                         
                }
	    	  },'-',{
                iconCls: 'icon-delete',
                text:'Delete',
                handler: function(){
                    
                    var ids='';
                    var ss=$("#userInfoManage_datagrid").datagrid('getSelections'); 
                   
                    if(ss.length==0){ 
                        $.messager.alert('Warning','At least select one item!');
                    }else{
                     
	                    $.messager.confirm('Information', 'Are you Sure to Delete?', function(r) {
	                        $.each(ss,function(n,v){
	                        	ids=ids+v.id+',' 
	                    });
                        $.ajax({
                            type:'post',
                            url:ctx+'/device/deletelist.do',
                            data:{'ids':ids},
                            dataType:"json",
                            success:function(data){
                                if(data=="success"){
                                    $.messager.alert('Information','Success');
                                   $("#userInfoManage_datagrid").datagrid('reload'); 
                                   
                               }else{
                                   $.messager.confirm('Information',"Failure");
                               }
                            }
                        })
                    });
                }
               }
	    	  }
	    	  ,'-',{
	                iconCls: 'icon-export',
	                text:'Export All',
	                handler: function(){
	                	window.location.href=ctx+"/device/export.do";
	                }
	    	  }
            ]
	});
	
	  
    var $userInfoManage_pagination = $('#userInfoManage_pagination');
    userInfoManage_pagination = $userInfoManage_pagination.pagination(
            {
//                pageList: [ 10, 50, 100, 300, 500 ],
                onSelectPage: function (pageNumber, pageSize) {
                    find(pageNumber, pageSize);
                }
            }).pagination('refresh', {
                total: 0,
                pageNumber: 1
            });

	 
	var p=$("#userInfoManage_datagrid").datagrid('getPager');
	 $(p).pagination({ 
	        pageSize: 10, 
	        pageList: [10, 50, 100, 300, 500], 
	        beforePageText: 'page', 
	        afterPageText: ' of   toal {pages} ', 
	        displayMsg: 'current {from} - {to} records   total {total}', 
	        /*onBeforeRefresh:function(){
	            $(this).pagination('loading');
	            alert('before refresh');
	            $(this).pagination('loaded');
	        }*/ 
	    });
	
	  
	 $("#userManage_toolbar_search").bind('click',function(){
		  
		 $('#userInfoManage_datagrid').datagrid('reload',{
				name: $('#name').val() 
			});
	 });
	
	 
	 $("#userManage_toolbar_cleanSearch").bind('click',function(){
		 $('#name').val('');
		 $('#email').val('');
		 
	 });
	 
});

 
$("#test1Manage_toolbar_add").click(function(){ 
	$('#addUser').dialog('open'); 
 });
 
$("#test1Manage_toolbar_edit").click(function(){ 
       
	$('#updateUser').dialog('open'); 
 });

function format1(val,row,index){
	if(val != undefined)
		return val.id; 
}
function formatName(val,row,index){
	if(val != undefined)
		return val.deviceDesc; 
}
function Channel(val,row,index){
	if(val != undefined)
		return val; 
}
function formatFloor(val,row,index){
	if(val != undefined)
		return val.floorNo; 
}
function formatBase(val,row,index,n){
	if(val != undefined)
		switch(n)
		{
		case 1:
			return val.id; 
		case 2:
			return val.deviceDesc; 
		case 3:
			return val.channelNo; 
		default:
			return val.floorNo;
		}
		
}
 
function changeDateFormat(val, row) {
    if (val != null) {
        var date = new Date(val);
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        return date.getFullYear() + "-" + month + "-" + currentDate;
    }
} 
 
//function excel(){
	
//	$("a[id='test1Manage_toolbar_export']").attr("href","/S2SH-Manager/testServlet");
//}

 
function msgInfo(msg){
	$.messager.show({   
        title : 'INFO',  
        timeout : 3000,  
        msg : msg,  
        showType : 'slide', 
        width: 260,  
        height: 200,  
        style : {  
            left : '',  
            top : '',  
              
            right : '0px', 
            bottom : '0px', 
              
            position:'fixed' 
        }  
    });
}