<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="./css/user_index.css">
	<script src="./js/user_index.js"></script>

  </head>
  
  <body>
   	<div class="header">
		<div>
			<!--浪美时尚logo-->
			<div class="logo"><img src="./images/util/logo.jpg" width="135px" height="108px" title="浪美时尚网络商城网"/></div>
			<!--搜索框-->
			<div class="search_bar">
				<br />
				<br />
				<form method="get">
					<input type="text" class="search_text" placeholder="请输入商名称"/><input type="button" class="search_button" value="搜索"/>
				</form>
				<table style="font-size:13px; color:#666;">
					<tr height="28px">
						<td width="100px"></td>
						<td width="90px">热门搜索：</td>
						<td width="50px"><a href="#" target="_blank">商品</a></td>
						<td width="50px"><a href="#" target="_blank">商品</a></td>
						<td width="50px"><a href="#" target="_blank">商品</a></td>
						<td width="50px"><a href="#" target="_blank">商品</a></td>
						<td width="50px"><a href="#" target="_blank">商品</a></td>
						<td width="50px"><a href="#" target="_blank">商品</a></td>
					</tr>
				</table>
			</div>
			<div class="goodcar">
				<div class="goodcar_1">
					<a href="ShoppingcarServlet.do?op=findAll&username=${sessionScope.user.username }" target="_blank">我的收藏夹&nbsp;&nbsp;></a>
					<span id="goodcar_span"></span>
					<div class="goodcar_2" id="goodcar"><br /><br /><br />农产品收藏夹空空如也，快来收藏点东西吧~</div>
				</div>
			</div>			
		</div>
	</div>
  </body>
</html>
