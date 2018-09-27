<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
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
    
    <title>浪美时尚后台-删除用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script src="./js/manager_util.js"></script>
	<style>
		.middle_deluser{
			width:580px; 
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
			width:180px; 
			height:22px; 
			margin:-25px 205px; 
			position:absolute;
			color:red;
			font-size:2px;
			line-height:22px;
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
			margin:120px 380px;
		}
		input{
			width:180px;
			height:30px;
			padding-left:5px;
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
					<div class="index_titlename">删除用户</div>
					<div class="middle_search">
						<jsp:include page="manager/search.jsp"></jsp:include>
					</div>
				</div>
				<div class="middle_main">
					<div class="middle_deluser">
						<form action="User.do?op=deluser" method="post">
							<table border="1px" cellspacing="0px" bordercolor="#FFF">
								<tr height="52px">
									<td width="210px">&nbsp;请输入您要删除的用户名：</td>
									<td width="365px">&nbsp;
										<input type="text" size="18" name="username"/><div class="msg" id="usernamemsg">${requestScope.errmsg}</div>
									</td>
								</tr>
								<tr align="center" height="42px">
									<td colspan="2">
										<input type="submit" class="submit" value="删除"/>							
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div class="succeed" id="succeed">${requestScope.succeedmsg}</div>
				</div>
			 </div>
		</div>
	</body>
</html>
