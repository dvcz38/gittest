var userInfoManage_pagination;
var userInfoManage_datagrid;

$(function(){
	
	
	//创建表格
	userInfoManage_datagrid = $("#userInfoManage_datagrid").datagrid({
		  url:ctx+"/index/findall.do",
		  striped: true,
		  fit: true,          //自动大小
		  singleSelect: false,//是否单选
		  pagination: true, //设置是否有分页功能
		  rownumbers: true,//行号
		  frozenColumns:
			  [[
                {field : 'ck',checkbox : true},
                {width: '70',title: 'ID',field: 'id'},
                { width: '100',title: 'User Name',field: 'name'},
      //          {width: '100',title: '支付宝外部商户',field: 'userName'}
		      ]],
		  columns:[[
		//		{width: '100',title: '受理商户名称',field: 'enableDate',sortable: true},     
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
	          	{width: '100',title: 'Join Date',field: 'joindate',sortable: true},
	          	{width: '120',title: 'State',field: 'state'}
	      ]],toolbar:'#userInfoManage_toolbar'
//	      onBeforeLoad: function (param) {
//	            parent.$.messager.progress({
//	                text: '数据加载中....'
//	            });
//	        },//toolbar: '',
//	      onLoadSuccess: function (data) {
//	            parent.$.messager.progress('close'); 
//		     }
	});
	
	 //分页控件加载
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

	//设置分页控件
	var p=$("#userInfoManage_datagrid").datagrid('getPager');
	 $(p).pagination({ 
	       // pageSize: 6,//每页显示的记录条数，默认为10 
	        pageList: [6,10,15],//可以设置每页记录条数的列表 
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	        /*onBeforeRefresh:function(){
	            $(this).pagination('loading');
	            alert('before refresh');
	            $(this).pagination('loaded');
	        }*/ 
	    });
	
	 //查询
	 $("#userManage_toolbar_search").bind('click',function(){
		  
		 $('#userInfoManage_datagrid').datagrid('load',{
				name: $('#name').val(),
				email: $('#email').val()
			});
	 });
	
	
	 //重置
	 $("#userManage_toolbar_cleanSearch").bind('click',function(){
		 $('#name').val('');
		 $('#email').val('');
		 
	 });
	 
});


//导出url
function excel(){
	
	$("a[id='test1Manage_toolbar_export']").attr("href","/S2SH-Manager/testServlet");
}

/**
 *  提示信息
 * @param msg
 */
function msgInfo(msg){
	$.messager.show({   
        title : '提示信息',  
        timeout : 3000,  
        msg : msg,  
        showType : 'slide', 
        width: 260,  
        height: 200,  
        style : {  
            left : '',  
            top : '',  
              
            right : '0px',//窗口离右边距离,于left互斥  
            bottom : '0px',//窗口离下边距离,于top互斥  
              
            position:'fixed'//元素定位方式：fixed固定。 默认:absolute绝对定位  
        }  
    });
}