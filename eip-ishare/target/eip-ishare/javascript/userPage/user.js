/**
 * 
 */

var userInfoManage_pagination;
var userInfoManage_datagrid;
//var products = [
//    		    {productid:'FI-SW-01',name:'Koi'},
//    		    {productid:'K9-DL-01',name:'Dalmation'},
//    		    {productid:'RP-SN-01',name:'Rattlesnake'},
//    		    {productid:'RP-LI-02',name:'Iguana'},
//    		    {productid:'FL-DSH-01',name:'Manx'},
//    		    {productid:'FL-DLH-02',name:'Persian'},
//    		    {productid:'AV-CB-01',name:'Amazon Parrot'}
//    		];
$(function(){
	
//	
//	 $('#userInfoManage_datagrid').datagrid({
//         title:'Editable DataGrid',
//         iconCls:'icon-edit',
//         width:660,
//         height:250,
//         singleSelect:true,
//         idField:'itemid',
//         url:'',
//         columns:[[
//             {field:'itemid',title:'Item ID',width:60},
//             {field:'productid',title:'Product',width:100,
//                 formatter:function(value){
//                     for(var i=0; i<products.length; i++){
//                         if (products[i].productid == value) return products[i].name;
//                     }
//                     return value;
//                 },
//                 editor:{
//                     type:'combobox',
//                     options:{
//                         valueField:'productid',
//                         textField:'name',
//                         data:products,
//                         required:true
//                     }
//                 }
//             },
//             {field:'listprice',title:'List Price',width:80,align:'right',editor:{type:'numberbox',options:{precision:1}}},
//             {field:'unitcost',title:'Unit Cost',width:80,align:'right',editor:'numberbox'},
//             {field:'attr1',title:'Attribute',width:150,editor:'text'},
//             {field:'status',title:'Status',width:50,align:'center',
//                 editor:{
//                     type:'checkbox',
//                     options:{
//                         on: 'P',
//                         off: ''
//                     }
//                 }
//             },
//             {field:'action',title:'Action',width:70,align:'center',
//                 formatter:function(value,row,index){
//                     if (row.editing){
//                         var s = '<a href="#" onclick="saverow(this)">Save</a> ';
//                         var c = '<a href="#" onclick="cancelrow(this)">Cancel</a>';
//                         return s+c;
//                     } else {
//                         var e = '<a href="#" onclick="editrow(this)">Edit</a> ';
//                         var d = '<a href="#" onclick="deleterow(this)">Delete</a>';
//                         return e+d;
//                     }
//                 }
//             }
//         ]],
//         onBeforeEdit:function(index,row){
////             row.editing = true;
////             updateActions(index);
//         },
//         onAfterEdit:function(index,row){
////             row.editing = false;
////             updateActions(index);
//         },
//         onCancelEdit:function(index,row){
////             row.editing = false;
////             updateActions(index);
//         }
//     }).datagrid('enableCellEditing');
	
	//创建表格
	userInfoManage_datagrid = $("#userInfoManage_datagrid").datagrid({
		  url:'',
		  striped: true,
		  fit: true,          //自动大小
		  singleSelect: false,//是否单选
		  pagination: true, //设置是否有分页功能
		  rownumbers: true,//行号
		  frozenColumns:
			  [[
                {field : 'ck',checkbox : true},
                {width: '70',title: '编号',field: 'userId'},
                { width: '100',title: '支付宝子商户',field: 'loginName'},
      //          {width: '100',title: '支付宝外部商户',field: 'userName'}
		      ]],
		  columns:[[
		//		{width: '100',title: '受理商户名称',field: 'enableDate',sortable: true},     
	          	{width: '100',title: '联系人姓名',field: 'orgNo'},    
	          	{width: '100',title: '电话',field: 'orgName'},    
	          	{width: '100',title: '手机号',field: 'phone'},
	          	{width: '100',title: '电子邮箱',field: 'email'},    
	          	{width: '100',title: '联系人类型',field: 'enableDate',sortable: true},
	          	{width: '120',title: '商户所在省份编码',field: 'addDate',sortable: true},
	          	{width: '120',title: '商户所在城市编码',field: 'enable',sortable: true},
	          	{width: '120',title: '商户所在区县编码',field: 'enable',sortable: true},
	          	{width: '120',title: '商户详细经营地址',field: 'invalidDate',sortable: true}
	      ]],toolbar:'#userInfoManage_toolbar'
//	      onBeforeLoad: function (param) {
//	            parent.$.messager.progress({
//	                text: '数据加载中....'
//	            });
//	        },//toolbar: '',
//	      onLoadSuccess: function (data) {
//	            parent.$.messager.progress('close');
//	       }
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
		 
	 });
	 
	 //重置
	 $("#userManage_toolbar_cleanSearch").bind('click',function(){
		 
		 
	 });
	 
//	 $("#test1Manage_toolbar_export").bind('click',function(){
//		//可以使用jQuery提供的serializeArray()方法序列化表单元素，返回json数据结构数据。
//		$.ajax({
//			 url: ctx+"/excel/exportAdmin.do",
////			 url: '/S2SH-Manager/testServlet',
//			 type:"GET", 
////		       dataType:"json",                    //则data可以是对象
//	         contentType:"application/json",    //则data只能是json字符串
////			 data:JSON.stringify(queryCondition),
//			 success:function(result){
//				 
////				 msgInfo(result.msg);
//				 
//			 },error:function(result){
//				 
////				 msgInfo("系统异常");
//			 }
//		});
//		 
//	 });
	
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


