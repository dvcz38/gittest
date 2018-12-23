var userInfoManage_pagination;
var userInfoManage_datagrid;

$(function(){
	 
    $('#updateUser').dialog('close');
    $('#addUser').dialog('close');
	
	 
	userInfoManage_datagrid = $("#userInfoManage_datagrid").datagrid({
		  url:ctx+"/device/dtl/getall.do",
 
		  loadFilter:pagerFilter,		
			rownumbers:true,
			singleSelect:false,
			pageSize:20,           
			pagination:true,
			multiSort:true,
			fitColumns:true,
			fit:true,
		  frozenColumns:
			  [[
                {field : 'ck',checkbox : true},
                {width: '70',title: 'ID',field: 'id'},
                //{width: '70',title: 'Device ID',field: 'id',function(val,row,index){if(row.device!=undefined) return row.device.id;}},    
                { width: '100',title: 'Device',field: 'device',formatter:formatName}
    
		      ]],
		  columns:[[
				{width: '200',title: 'Date Time',field: 'inputDt',sortable: true},     
				{width: '100',title: 'Channel',field: 'channelNo',sortable: true,formatter:function(val,row,index){if(row.device!=undefined) return row.device.channelNo;}}, 
	          	{width: '100',title: 'Floor',field: 'floorNo', formatter:function(val,row,index){if(row.device!=undefined) return row.device.floorNo;}},    
	          	{width: '100',title: 'Signal Power',field: 'nbSignalPwr'},  
	          	{width: '100',title: 'Battery Vol',field: 'battVol'}, 
	          	{width: '100',title: 'Door Distance',field: 'doorDistance'}, 
	          	{width: '100',title: 'Door Status',field: 'doorStatus',sortable: true},
	          	{width: '120',title: 'Check Status',field: 'isStaffCheck'},
	          	{width: '120',title: 'Staff Number',field: 'staffno'}
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
                  
	                    $.messager.confirm('Information', 'Are You Sure to Delete?', function(r) {
	                        $.each(ss,function(n,v){
	                        	ids=ids+v.id+',' 
	                    });
                        $.ajax({
                            type:'post',
                            url:ctx+'/device/dtl/deletelist.do',
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
	    	  },'-',{
	                iconCls: 'icon-export',
	                text:'Export All',
	                handler: function(){
	                	window.location.href=ctx+"/device/dtl/export.do";
	                }
	    	  }
            ]
	});
	
	/* 配置添加框 */
	$("#addUserForm").form({
	    type:'post',
	    url:ctx+'/device/dtl/add.do',
	    dataType:"json",
	    success : function(data) {
	        if(data=="success"){
	            
	            $('#addUser').dialog('close');
	            $('#addUserForm').form('clear');
	            $.messager.alert('Information','Successfully','info',function(){
	                $('#userInfoManage_datagrid').datagrid('reload');
	            });
	        }else{
	            $.messager.alert('Information','Failure','info'
//	            		,function(){
//	                        $("#addStuf").form('clear');
//	                    }
	            );
	        }
	    }
	});
//	 data:{
//	    	'id':id,
//	    	'deviceDesc':$("#deviceDesc").val()
//	    	},
	/* 配置修改框 */
	$("#upUserForm").form({
	    type:'post',
	    url:ctx+'/device/dtl/update.do',
	    dataType:"json", 
	   
	    success : function(data) {
	    
	        if(data=="success"){
	            
	           $("#userInfoManage_datagrid").datagrid('reload'); 
	           $.messager.alert('Information','Update Successfully',function(){
	               $('#userInfoManage_datagrid').datagrid('reload');
	           });    
	           $('#updateUser').dialog('close');
	           
	       }else{
	           $.messager.alert('Information','Update User Fail!','Update Failure!');  
	          
	       }
	    }
	});
	
     
});

function pagerFilter(data){            
	if (typeof data.length == 'number' && typeof data.splice == 'function'){// is array                
		data = {                   
			total: data.length,                   
			rows: data               
		}            
	}        
	var dg = $(this);         
	var opts = dg.datagrid('options');          
	var pager = dg.datagrid('getPager');          
	pager.pagination({                
		onSelectPage:function(pageNum, pageSize){                 
			opts.pageNumber = pageNum;                   
			opts.pageSize = pageSize;                
			pager.pagination('refresh',{pageNumber:pageNum,pageSize:pageSize});                  
			dg.datagrid('loadData',data);                
		}          
	});           
	if (!data.originalRows){               
		data.originalRows = (data.rows);       
	}         
	var start = (opts.pageNumber-1)*parseInt(opts.pageSize);          
	var end = start + parseInt(opts.pageSize);        
	data.rows = (data.originalRows.slice(start, end));         
	return data;       
}
function changeDateFormat(val, row) {
    if (val != null) {
        var date = new Date(val);
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        return date.getFullYear() + "-" + month + "-" + currentDate;
    }
} 
function formatName(val,row,index){
	if(val != undefined)
		return val.deviceDesc; 
}
//配置修改学生信息表单提交
function updateForm() {
    $("#upUserForm").form('submit');
}

function addForm() {
    $("#addUserForm").form('submit');
    
}

function find(pageNumber, pageSize)
{
    if(true)
    {
        $("#userInfoManage_datagrid").datagrid('getPager').pagination({pageSize : pageSize, pageNumber : pageNumber});//重置
        $("#userInfoManage_datagrid").datagrid("loading"); //加屏蔽
        $.ajax({
            type : "POST",
            dataType : "json",
            url:ctx+'/device/dtl/finduser.do',
            data : {
                'page' : pageNumber,
                'rows' : pageSize
            },
            success : function(data) {
                $("#userInfoManage_datagrid").datagrid('loadData',pageData(data.rows,data.total));
				//这里的pageData是我自己创建的一个对象，用来封装获取的总条数，和数据，data.rows是我在控制器里面添加的一个map集合的键的名称
                var total =data.total;
                $("#userInfoManage_datagrid").datagrid("loaded"); 
				//移除屏蔽
            },
            error : function(err) {
                $.messager.alert('Information', 'update fail', 'error');
                $("#userInfoManage_datagrid").datagrid("loaded"); //移除屏蔽
            }
        });
    }
}

function pageData(list,total){
    var obj=new Object(); 
    obj.total=total; 
    obj.rows=list; 
    return obj; 
} 


/**
 *   
 * @param msg
 */
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