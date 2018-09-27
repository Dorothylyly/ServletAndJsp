<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	if(session.getAttribute("manager") == null){
		response.sendRedirect("managerlogin.jsp");
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>浪美时尚后台-添加商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="./js/manager_util.js"></script>
	
	<style>
		.middle_adduser{
			width:540px; 
			margin:20px auto; 
			background:#F5F5F5; 
			box-shadow:1px 2px 3px #CCCCCC
		}
		.submit{
			width:100px;
			height:32px;
			padding:0px;
			border:1px solid skyblue;
			background:skyblue;
			color:#FFF;
			font-weight:bold;
		}
		.msg{
			width:160px; 
			height:26px; 
			margin:-26px 220px; 
			position:absolute;
			color:red;
			font-size:2px;
		}
		.succeed{
			width:320px; 
			height:80px;
			font-size:30px;
			color:#093;
			font-weight:bold;
			background:#DFDFDF;
			line-height:80px;
			text-align:center;
			border-radius:10px;
			position:absolute;
			z-index:20;
			margin:20px 380px;
		}
		input{
			width:180px;
			height:30px;
			padding-left:5px;
		}
		.text{
			width:60px;
			height：50px;
		}
	</style>

  </head>
  
	<body>
		<div class="top_index">
			<jsp:include page="manager/top.jsp"></jsp:include>
		</div>
		<div class="middle">
			<div class="middle_menu">
				<jsp:include page="manager/left.jsp"></jsp:include>    		
			</div>
			<div class="middle_right">
				<div class="middle_index">
					<div class="index_titlename">添加商品</div>
					<div class="middle_search">
						<jsp:include page="manager/search.jsp"></jsp:include>
					</div>
				</div>
				<div class="middle_main">
					<div class="middle_adduser">
						<form action="Good.do?op=adduser" method="post">
						    <table border="1px" cellspacing="0px" bordercolor="#FFF">
						        <tr height="50px">
						            <td width="160px">&nbsp;输入商品名称：</td>
						            <td width="380px">&nbsp;
						                <input type="text" size="18" name="goodname" id="goodname"/>
						            </td>
						        </tr>
						        <tr height="50px">
						            <td>&nbsp;请输积分：</td>
						            <td>&nbsp;
						                <input type="text" size="18" name="score" id="score"/>
						            </td>
						        </tr>
						        <tr height="50px">
						            <td>&nbsp;请输入商品市场价：</td>
						            <td>&nbsp;
						                <input type="text" size="18" name="price" id="price"/>
						            </td>
						        </tr>
						        <tr height="50px">
						            <td>&nbsp;请输入会员价：</td>
						            <td>&nbsp;
						                <input type="text" size="18" name="memberprice" id="memberprice"/>
						            </td>
						        </tr>
						        <tr height="50px">
						            <td>&nbsp;请输入数量：</td>
						            <td>&nbsp;
						                <input type="text" size="18" name="num" id="num"/>
						            </td>
						        </tr>						      						       
						        <tr height="50px">
						            <td>&nbsp;请输入图片路径：</td>
						            <td>&nbsp;
							            <!-- <form action="Fupload.do" method="post"> -->
							                <input type="file" size="18" name="picurl" id="picurl" onchange="loadfile(this);"/>			
							               	<input type="submit" value="上传"/><br/>
							            <!-- </form> -->
							           	<font color="red">${requestScope.errmsg }</font>
							            <img src="${requestScope.svfile}" />
						            </td>
						        </tr>						        						        						        
						        <tr height="52px" align="center">
						            <td colspan="2"><input type="submit" value="确认" class="submit"/></td>
						        </tr>
						    </table>
						</form>
					</div>
					<div class="succeed" id="succeed">${requestScope.succeedmsg}</div>
				</div>
			 </div>
		</div>
		<script src="./js/manager_user_add.js"></script>
	</body>
</html>
