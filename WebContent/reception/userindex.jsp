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
    
    <title>涵小涵的农产品展示网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="./css/user_index.css">
	<script src="./js/user_index.js"></script>

  </head>
  
  <body>
    <div class="bigtop" id="bigtop"></div>
   	<div class="header_hidden" id="header">
   		<div style="width:1200px; margin:auto;">
	   		<div style="width:320px; padding-top:8px; color:#C30; font-weight:bold; float:left;">
				<div style="font-size:20px;">涵小涵的农产品展示网</div>
				<div style="font-size:18px;">Kaisen.com</div>
			</div>
			<div style="float:left; padding-top:8px; width:560px;">
				<form method="get" action="#">
					<input type="text" placeholder="该功能不存在请勿点击搜索" class="search_text"/><input type="button" class="search_button" value="搜索"/>
				</form>
			</div>
			<div style="float:left; padding-top:8px;">
				<div class="goodcar" style="margin-top:0px;">
					<div class="goodcar_1">
						<a href="ShoppingcarServlet.do?op=findAll&username=${sessionScope.user.username }" target="_blank">我的收藏&nbsp;&nbsp;></a>
						<span id="goodcar_span"></span>
						<div class="goodcar_2" id="goodcar"><br /><br /><br />收藏夹饿扁了，快点东西吧~</div>
					</div>
				</div>	
			</div>
   		</div>
	</div>
	<div style="width:1200px; margin:auto;">
		<% if(session.getAttribute("user") == null){%>
			<jsp:include page="user/top.jsp"></jsp:include>
		<%}else{ %>
			<jsp:include page="user/top2.jsp"></jsp:include>
		<%} %>
		<div style="height:38px;"></div>
		<jsp:include page="user/header.jsp"></jsp:include>
		<!--返回顶部 -->
		<a href="javascript:scrollTo(0,0)"><div class="back_top">∧</div></a>
		<!--主导航-->
		<div class="main">
			<div class="nav">
				<ul>
					<li style="width:255px; color:#FFF; background:#C00; text-align:left;">&nbsp;&nbsp;&nbsp;全部商品分类</li>
					<li><a href="#" target="_blank"><span>水果类</span></a></li>
					<li><a href="#" target="_blank"><span>蔬菜类</span></a></li>
					<li><a href="#" target="_blank"><span>导航</span></a></li>
					<li><a href="#" target="_blank"><span>导航</span></a></li>
					<li><a href="#" target="_blank"><span>导航</span></a></li>
					
				</ul>
			</div>
			<!--分类导航-->
			
			<div style="background:#0C6; height:430px;background-image:url(./images/userindex/主页海报ao.jpg);" id="menu1"></div>
			<div style="background:#0C6; height:430px;background-image:url(./images/userindex/主页海报ao.jpg); display:none;" id="menu2"></div>
			<div style="background:#0C6; height:430px;background-image:url(./images/userindex/主页海报ao.jpg); display:none;" id="menu3"></div>
			<div style="background:#0C6; height:430px;background-image:url(./images/userindex/主页海报ao.jpg); display:none;" id="menu4"></div>
			<div style="background:#0C6; height:430px;background-image:url(./images/userindex/主页海报ao.jpg); display:none;" id="menu5"></div>
			<div style="background:#0C6; height:430px;background-image:url(./images/userindex/主页海报ao.jpg); display:none;" id="menu6"></div>
			<div style="background:#0C6; height:430px;background-image:url(./images/userindex/主页海报ao.jpg); display:none;" id="menu7"></div>
			<div style="background:#0C6; height:430px;background-image:url(./images/userindex/主页海报ao.jpg); display:none;" id="menu8"></div>
			<div style="background:#0C6; height:430px;background-image:url(./images/userindex/主页海报ao.jpg); display:none;" id="menu9"></div>
		</div>
		
		
		<!--最新商品-->
		<div style="height:25px; font-size:21px; font-weight:700;font-family:微软雅黑; margin-top:46px; margin-left:22px;">最新农产品</div>
		<div class="guess_like">
		<c:forEach var="g" items="${requestScope.goodlist}">
			<a href="UserGoodServlet.do?goodId=${g.id }" target="_blank">
				<div class="like1">
					<div class="like_1"><img src="${g.picurl }" style="widht:180px; height:160px; margin-top:28px"/></div>
					<div class="like_2">${g.goodname }</div>
					<div class="like_3">市场价：${g.price }</div>
					<div class="like_4">产地：${g.address }</div>
				</div>
			</a>
		</c:forEach>
		</div>
		<!--承诺广告-->
		<div style="height:15px;"></div>
		<div class="foot"><img src="./images/userindex/acceptance.png" title="涵小涵的农产品展示网" width="100%" style="cursor:pointer"/></div>
		<div style="height:15px;"></div>
		<!--版权-->
		
	</div>
	<div style="position:absolute; width:100%; height:120px; background:#EAEAEA; z-index:-1; margin-top:-120px;"></div>
  </body>
</html>
