var userInfoManage_pagination;
var userInfoManage_datagrid;

$(function(){
	
    $('#updateUser').dialog('close');
    $('#addUser').dialog('close');
	
	
	userInfoManage_datagrid = $("#userInfoManage_datagrid").datagrid({
		  url:ctx+"/index/findall.do",
		  striped: true,
		  fit: true,          
		  singleSelect: false,
		  pagination: true, 
		  rownumbers: true,
		  frozenColumns:
			  [[
                {field : 'ck',checkbox : true},
                {width: '70',title: 'ID',field: 'id'},
                { width: '100',title: 'User Name',field: 'name'},
		      ]],
		  columns:[[
		
	          	{width: '100',title: 'Role',field: 'role',
	          		formatter: function (val, row) {
	          		                  if (val == 1) {
	          			                      return "Super Admin";
	          			                  }
	          			                  else if (val == 2) {
	          			                      return "Admin";
	          			                  }
	          			                  else {
	          			                	  return "Common";
	          			                }	          			                	  
	          			              }},    
	          	{width: '100',title: 'Tel NO.',field: 'phone'},  
	          	{width: '100',title: 'Email',field: 'email'}, 
	          	{width: '100',title: 'Join Date',field: 'joindate',sortable: true,formatter:changeDateFormat},
	          	{width: '120',title: 'State',field: 'state'}
	      ]],toolbar:
	    	 // '#userInfoManage_toolbar'
//	      onBeforeLoad: function (param) {
//	            parent.$.messager.progress({
//	                text: '....'
//	            });
//	        },//toolbar: '',
//	      onLoadSuccess: function (data) {
//	            parent.$.messager.progress('close'); 
//		     }
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
                            url:ctx+'/index/deletelist.do',
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
	                	
	                }
	    	  }
            ]
	});
	
	/* 配置添加框 */
	$("#addUserForm").form({
	    type:'post',
	    url:ctx+'/index/add.do',
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

	/* 配置修改框 */
	$("#upUserForm").form({
	    type:'post',
	    url:ctx+'/index/update.do',
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
	
    var $userInfoManage_pagination = $('#userInfoManage_pagination');
    userInfoManage_pagination = $userInfoManage_pagination.pagination(
            {
                pageList: [ 10, 50, 100, 300, 500 ],
                onSelectPage: function (pageNumber, pageSize) {
                    fSearch();
                }
            }).pagination('refresh', {
                total: 0,
                pageNumber: 1
            });

	
	var p=$("#userInfoManage_datagrid").datagrid('getPager');
	 $(p).pagination({ 
	     
	        pageList: [6,10,15],
	        beforePageText: 'page',
	        afterPageText: ' of   toal {pages} ', 
	        displayMsg: 'current {from} - {to} records   total {total}', 
	        /*onBeforeRefresh:function(){
	            $(this).pagination('loading');
	            alert('before refresh');
	            $(this).pagination('loaded');
	        }*/ 
	    });
	
	/*
	 $("#userManage_toolbar_search").bind('click',function(){
		  
		 $('#userInfoManage_datagrid').datagrid('reload',{
				name: $('#name').val() 
			});
	 }); 
	 $("#userManage_toolbar_cleanSearch").bind('click',function(){
		 $('#name').val('');
		 $('#email').val('');
		 
	 });
	 */
});


/*
$("#test1Manage_toolbar_add").click(function(){ 
	$('#addUser').dialog('open');
 });

$("#test1Manage_toolbar_edit").click(function(){ 
       
	$('#updateUser').dialog('open');
 });
 
function excel(){
	
	$("a[id='test1Manage_toolbar_export']").attr("href","/S2SH-Manager/testServlet");
}
 */
function changeDateFormat(val, row) {
    if (val != null) {
        var date = new Date(val);
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        return date.getFullYear() + "-" + month + "-" + currentDate;
    }
} 

//配置修改学生信息表单提交
function updataForm() {
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
            url:ctx+'/index/finduser.do',
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