<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/icon.css">
    <script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function(){
        	console.log("${ctx}/index/finduser.do");
            $('#test').datagrid({
                singleSelect:true,
                title:'User List',
                iconCls:'icon-save',
                nowrap: false,
                striped: true,
                collapsible:false,
                url:'${ctx}/index/finduser.do',//加载表格后台数据
                sortName: 'id',//指定排序列
                sortOrder: 'asc',//升序
                remoteSort: false,
                idField:'id',
                frozenColumns:[[  //配置冻结列
                	 //{field:'ck',checkbox:true},准备多选框列
                    {title:'id',field:'id',width:80,sortable:true}//主键列
                ]],
                columns:[[
                    {field:'name',title:'登陆名',width:120},
                    {field:'password',title:'昵称',width:220,rowspan:2,sortable:false},
                    {field:'email',title:'昵称',width:220,rowspan:2,sortable:false}
                ]],
                pagination:true,//是否分页
                rownumbers:true,//是否显示行号
                toolbar:[{
                    id:'btnadd',
                    text:'添加用户',
                    iconCls:'icon-add',
                    handler:function(){
                        //清空表单
                        $('#ff').form('clear');
                        open1();
                    }
                },{
                    id:'btncut',
                    text:'修改用户',
                    iconCls:'icon-pencil',
                    handler:function(){
                        //获得被选中的行并回显数据
                        getSelected();
                    }
                },{
                    id:'btnsave',
                    text:'删除用户',
                    iconCls:'icon-cancel',
                    handler:function(){
                        //获得被选中的行
                        var selected = $('#test').datagrid('getSelected');
                        //未获得,提示
                        if (!selected){
                            alert("请选择一行再操作!");
                            return;
                        }else {
                            alert("请选中一行!");
                        }
                        //发送ajax请求访问后台删除用户
                            //成功,刷新表单
                        $.post("${ctx}/index/removeuser.do",
                                { user_id: selected.id },
                           function(data){
                             alert("操作成功!");
                         });
                        //刷新表单
                        $('#test').datagrid('reload');
                    }
                }]
            });
            var p = $('#test').datagrid('getPager');
            $(p).pagination({
                onBeforeRefresh:function(){
                    alert('before refresh');
                }
            });
        });

        function resize(){
            $('#w').window({
                title: 'New Title',
                width: 600,
                modal: true,
                shadow: false,
                closed: false,
                height: 300
            });
        }
        function open1(){
            $('#w').window('open');
        }
        function close1(){
            $('#w').window('close');
        }
        //指定表单是ajax提交
        $('#ff').form({ 
            url:'${ctx}/index/adduser.do', 
            onSubmit:function(){return true},
            success: function(data){    
                alert(data);    
                //清空表单数据
                $('#w').window('clear');
                //关闭窗口
                close1();
                //刷新列表
                $('#test').datagrid('reload');    
            }    
        });  
        //提交表单
        function submitForm() {
            $('#ff').submit();  
        }
        //获得被选中的行
        function getSelected(){
            var selected = $('#test').datagrid('getSelected');
            if (selected){//如果选中
                // alert(selected.user_id+":"+selected.user_name+":"+selected.user_code); 
                //回显数据
                $('#ff').form('load',{
                    user_id:selected.id,
                    user_name:selected.name,
                    user_code:selected.password,
                });
                //显示窗口
                open1();
            }else {
                alert("请选中一行!");
            }
        }
    </script>
</head>
<body>
    <table id="test" ></table>
    <div id="w" class="easyui-window" title="操作" closed="true" iconCls="icon-save" style="width:500px;height:200px;padding:5px;">
         <form id="ff" method="post" novalidate>
            <div>
                <label for="user_code">登录名:</label>
                <input class="easyui-validatebox" type="text" name="user_code" required="true"></input>
            </div>
            <div>
                <label for="user_name">昵&nbsp;称:</label>
                <input class="easyui-validatebox" type="text" name="user_name" required="true"></input>
            </div>
            <div>
                <label for="user_password">密&nbsp;码:</label>
                <input class="easyui-validatebox" type="text" name="user_password" required="true"></input>
            </div>
            <div>
                <input type="button"  onclick="submitForm()" value="提交" >
            </div>
        </form>
    </div>
</body>
</html> 