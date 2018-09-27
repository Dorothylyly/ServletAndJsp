<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
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
    
    <title>浪美时尚后台-查看订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./css/manager_index.css"/>
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
					<div class="index_titlename">查看订单</div>
					<div class="middle_search">
						<jsp:include page="manager/search.jsp"></jsp:include>
					</div>
				</div>
				<div class="middle_main">
					<div style="width:1070px; background:#F5F5F5; margin:6px 5px; box-shadow:1px 2px 3px #CCCCCC">
						<table border="1px" width="100%" cellspacing="0px" bordercolor="#FFF">
							<tr height="38px" align="center" style="font-weight:bold">
								<td width="15%">订单图片</td>
								<td width="15%">用户名</td>
								<td width="25%">商品名称</td>
								<td width="10">订单状态</td>
								<td width="30%">操作</td>							
							</tr>
							<c:forEach var="i" items="${requestScope.indentList}">
								<tr align="center" height="30px">
									<td><img src="${i.picurl }" width="70px" height="60px"/></td>
									<td>${i.username}</td>
									<td>${i.goodname}</td>
									<td>${i.state}</td>
									<td align="center" width="25%">
										<a href="Indent.do?op=detail&actionid=${i.actionid }"><font color="#2894FF">详情</font></a>					
										<c:if test="${i.state == '已付款'}">
											<form action="Indent.do?op=upIndent" method="post" style="position:absolute; margin:-20px 190px;">
												<input type="hidden" name="actionid" value="${i.actionid }"/>
												<input type="submit" style="background:#2894FF; color:#FFF; border:none; width:50px; height:22px;" value="发货"/>
											</form>	
										</c:if>			
									</td>
								</tr>				
							</c:forEach>
							<tr align="center">
								<td colspan="5" height="56px;">
									<div style="position: absolute; margin-left:55%;">
										<form action="#" method="get" name="myform">
											<input type="text" value="1" class="middle_num"/><input type="submit" value="Go" class="middle_submit"/>
										</form>
									</div>
									${requestScope.totalpages }/${requestScope.pageno } &nbsp;&nbsp;&nbsp;
									<a href="Indent.do?op=first">首页</a> &nbsp;&nbsp;&nbsp;
									<a href="Indent.do?op=prepage">上页</a> &nbsp;&nbsp;&nbsp;
									<a href="Indent.do?op=next">下页</a> &nbsp;&nbsp;&nbsp;
									<a href="Indent.do?op=last">末页</a>
								</td>
							</tr>	
						</table>											
					</div>
				</div>
			 </div>
		</div>
  	</body>
</html>
