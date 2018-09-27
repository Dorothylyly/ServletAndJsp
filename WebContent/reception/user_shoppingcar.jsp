<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>涵小涵农产品展示网-收藏夹</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="./css/user_shoppingcar.css"/>
	<script src="./js/user_shoppingcar.js"></script>
	
  </head>
  
  <body>
	<div style="height:35px;;width:100%;border-bottom:1px solid #CCC; z-index:-1; position:absolute; background:#EFEFEF;"></div>
	<div style="width:1200px; margin:auto;">
    	<!--顶部索引-->
		<% if(session.getAttribute("user") == null){%>
			<jsp:include page="user/top.jsp"></jsp:include>
		<%}else{ %>
			<jsp:include page="user/top2.jsp"></jsp:include>
		<%} %>		
		<div class="header">
			<div>
				<!--涵小涵农产品logo-->
				<div class="logo"><a href="UserIndexServlet.do"><img src="./images/util/logo.jpg" width="135px" height="108px" title="涵小涵农产品展示网"/></a>收藏夹</div>
				<!--搜索框-->
				<div class="search_bar">
					<br />
					<br />
					<form method="post">
						<input type="text" style="height:38px; width:380px; border:3px solid #C00; padding-left:5px;" placeholder="请输入商名称"/><input type="button" style="height:38px; width:80px; background:#C00; vertical-align:top; border:0px solid #C00; color:#FFF; font-size:18px; font-weight:bold;" value="搜索"/>
					</form>
				</div>
			</div>
		</div>
		<form method="post" action="#">
	        <div style="height:30px; width:100%; border-bottom:1px solid #C30;">
	         
	        	<div style="font-size:22px; color:#C30; float:left;">全部农产品</div>
	        </div>
	        <div style="width:1200px; height:36px; background:#FCFCFC; line-height:36px; font-size:8px;">
	        	<div style="width:160px; float:left;">&nbsp;<input type="checkbox" id="action" onclick="selectAll()"/>&nbsp;全选</div>
				<div style="width:500px; float:left;">农产品名称</div>
				<div style="width:140px; float:left;">产地</div>
	            <div style="width:150px; float:left;">市场价（元）</div>
				<div style="width:120px; float:left;">上市季节</div>
	        </div>
	        <c:if test="${empty requestScope.shoppingcarlist}">
	  	    	<jsp:include page="user/shoppingcar.jsp"></jsp:include>      
	        </c:if>
	        <c:if test="${!empty requestScope.shoppingcarlist}">
		        <c:forEach var="s" items="${requestScope.shoppingcarlist}">
					<div style="width:1200px; height:150px; background:#F9F9F9; margin-top:30px; border:1px solid #CCC;">
						<div style="height:20px;"></div>
			        	<div style="width:160px; float:left;">
			        		<div style="float:left; margin-left:10px;">&nbsp;<input type="checkbox" name="produce"/></div>
			        		<div style="width:90px; height:100px; float:left; margin-left:15px;">
			        			<img src="${s.picurl }" width="90px" height="100px"/>
			        		</div>
			        	</div>
						<div style="width:500px; float:left;">
							
						</div>
						<div style="width:90px; height:100px; float:left;">
							<div style="color:#666666;">${s.goodname }</div>
							<div style="font-weight:bold;">${s.address }</div>
						</div>
			            <div style="width:160px; height:100px; float:left; margin-left:30px">
			           		<input type="button" class="botton_num" id="subNum" value="-" onclick="operationType(this)"/><input type="text" id="num" class="text_num" value="${s.price}" onblur="operationType(this)"/><input type="button" id="addNum" class="botton_num" />
			            </div>
						<div style="width:120px; height:100px; float:left; color:#C30; font-size:20px; font-weight:bold;">
							${s. season}
						</div>
						
			        </div>
		        </c:forEach>
	        </c:if>	   
	        
   		</form>
   		<div style="height:22px;"></div>
   		<!--版权-->
		<jsp:include page="user/bottom.jsp"></jsp:include>
	</div>
	<div style="position:absolute; width:100%; height:120px; background:#EAEAEA; z-index:-1; margin-top:-120px;">
  </body>
</html>
