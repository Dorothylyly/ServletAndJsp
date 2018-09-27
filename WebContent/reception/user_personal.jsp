<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>涵小涵农产品展示网-个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./css/user_personal.css"/>
	<script src="./js/user_personal.js"></script>

  </head>
  
  <body>
	<div style="height:35px;;width:100%;border-bottom:1px solid #CCC; z-index:-1; position:absolute; background:#EFEFEF;"></div>
    <div style="width:100%; height:60px; background:#C30; z-index:-1; position:absolute; margin-top:35PX;"></div>
	<div style="width:1200px;margin:auto;">
    	<!--顶部索引-->
		<% if(session.getAttribute("user") == null){%>
			<jsp:include page="user/top.jsp"></jsp:include>
		<%}else{ %>
			<jsp:include page="user/top2.jsp"></jsp:include>
		<%} %>
        <div class="header">
        	<div class="header_title">我的农产品</div>
            <div class="header_nav">
                <ul>
                    <li><a href="UserIndexServlet.do" class="index_a">首页</a></li>
                    <li><del>个人中心</del></li>
                    <li><del>消息</del></li>
                </ul>
            </div>
            <div class="headezr_search">
            	<form action="#" method="get">
                	<input type="text" id="search" placeholder="该功能不存在请勿点击搜索" name="search"/><input type="submit" value="搜索" id="submit" name="submit"/>
                </form>
            </div>
        </div>
        <div class="main">
        	<div class="main_left">
            	<div class="left_member">会员中心</div>
                <div class="left_menu">
                    <ul>
                        <li class="main_left_li" onclick="show(1)">个人设置</li>
						<div class="show" id="manager1">
                            <ul>
                                <li><a href="UserUserServlet.do?username=${sessionScope.user.username }">个人资料</a></li>
                                <li><a href="UserUserServlet.do?op=upDate&username=${sessionScope.user.username }">修改资料</a></li>
                            </ul>
               			</div>
                        <li class="main_left_li" onclick="show(2)">我的收藏夹</li>
                        <div class="show" id="manager2">
                            <ul>
                                <li><a href="ShoppingcarServlet.do?op=findAll&username=${sessionScope.user.username }">购物车</a></li>
                            </ul>
                        </div>
                        <li class="main_left_li" onclick="show(3)">我的订单</li>
                        <div class="show" id="manager3">
                            <ul>
                                <li style="border-bottom:1px solid #CCC;"><a href="UserIndentServlet.do?username=${sessionScope.user.username }">已买到的宝贝</a></li>
                            </ul>
                        </div>
                    </ul>
                </div>
            </div>
           	<div class="main_right">
            	<div class="right_top1">
            		&nbsp;&nbsp;&nbsp;<b>您好！欢迎回来。</b>
            	</div>
                <div class="right_main">
                	<div style="margin:150px 420px;">
                		<img src="./images/util/logo.jpg"/>
                    </div>
                </div>
            </div>
        </div>
   		<div style="height:65px;"></div>
   		<!--版权-->
		<jsp:include page="user/bottom.jsp"></jsp:include>
    </div>
	<div style="position:absolute; width:100%; height:120px; background:#EAEAEA; z-index:-1; margin-top:-120px;">
  </body>
</html>
