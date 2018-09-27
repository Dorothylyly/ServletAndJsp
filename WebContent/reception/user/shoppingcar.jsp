<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shoppingcar2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  	<style type="text/css">

  	</style>
  </head>
  
  <body>
   	<div class="null_shoppingcar">
   		<div class="null_shoppingcar_text">
   		农产品收藏夹空空如也，快来收藏点东西吧~
   			<% if(session.getAttribute("user") == null){%>
				<br/><font size="+1">系统检测到您未登陆，</font><a href="userlogin.jsp" style="font-size:
				13px; color:#06F;">请登录</a>
			<%}%>
   		</div>
   	</div>
  </body>
</html>
