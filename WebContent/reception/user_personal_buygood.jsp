<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<div style="height:35px; width:100%; border-bottom:1px solid #CCC; z-index:-1; position:absolute; background:#EFEFEF;"></div>
    <div style="width:100%; height:60px; background:#C30; z-index:-1; position:absolute; margin-top:35PX;"></div>
	<div style="width:1200px; margin:auto;">
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
       	<div style="height:20px;"></div>
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
                       <li class="main_left_li" onclick="show(2)">我的收藏</li>
                       <div class="show" id="manager2">
                           <ul>
                               <li><a href="ShoppingcarServlet.do?op=findAll&username=${sessionScope.user.username }">收藏夹</a></li>
                           </ul>
                       </div>
                       <li class="main_left_li" onclick="show(3)">我的心愿农产品订单</li>
                       <div class="show" id="manager3">
                           <ul>
                               <li style="border-bottom:1px solid #ccc;"><a href="UserIndentServlet.do?username=${sessionScope.user.username }">已收藏的宝贝</a></li>
                           </ul>
                       </div>
                   </ul>
               </div>
           </div>
        	<div class="buy_main_right">
          	<div class="buy_right_top">
              	<div style="width:380px; text-align:center; float:left;">涵小涵农产品</div>
              	<div style="width:90px; float:left;">单价（元）</div>
              	<div style="width:90px; text-align:center; float:left;">数量</div>
            	<div style="width:160px; text-align:center; float:left;">实付款（元）</div>
              	<div style="width:120px; float:left;">交易状态</div>
              	<div style="width:150px; float:left;">交易操作</div>
              </div>
            <div class="buy_right_main">
				<c:forEach var="i" items="${requestScope.indentList}">
					<div style="width:990px; height:150px; border:1px solid #CCC; font-size:13px;">
						<div style="background:#EAF8FF; height:38px; line-height:38px;">
							&nbsp;<input type="checkbox" name="produce"/>
							&nbsp;<b>${i.actiondate }</b>
							&nbsp;订单号：${i.actionid }
						</div>
			        	<div style="width:120px; float:left;">
			        		<div style="width:90px; float:left; margin:10px 15px;">
			        			<img src="${i.picurl }" width="90px" height="90px"/>
			        		</div>
			        	</div>
						<div style="width:260px; float:left; margin-top:10px;">${i.goodname }</div>
						<div style="width:90px; height:100px; float:left; margin-top:10px; ">
							<font color="#666666">${i.price }</font>
							<b>${i.memberprice }</b>
						</div>
						<div style="width:90px; height:100px; float:left; margin-top:10px; text-align:center; font-weight:bold;">
							${i.productnum }
						</div>
			            <div style="width:160px; height:100px; float:left; margin-top:10px; text-align:center;">			       
			           		<b>${i.total }</b>
			           		<br/>（含运费0.00）
			            </div>
						<div style="width:120px; height:100px; float:left; margin-top:10px;">
							<ul style="list-style-type:none;">
								<li style="height:20px;"><del>交易成功</del></li>
								<li style="height:20px;"><del>订单详情</del></li>
								<li style="height:20px;"><del>查看物流</del></li>
								<li style="height:20px;"><del>双方已评</del></li>								
							</ul>
						</div>
						<div style="width:150px; height:100px; float:left; margin-top:10px;">
							<c:if test="${i.state == '已付款'}">
								<u><font color="#2894FF"><del>提醒发货</del></font></u>
							</c:if>		
							<c:if test="${i.state == '已发货'}">
								<form action="UserIndentServlet.do?op=upIndent&username=${sessionScope.user.username }" method="post">
									<input type="hidden" name="actionid" value="${i.actionid }"/>
									<input type="submit" value="确认收货" style="width:80px; height:32px; background:skyblue; border:none; color:#FFF;"/>
								</form>	 
							</c:if>	
							<c:if test="${i.state == '已签收'}">
								立即评论
							</c:if>		
						</div>
			        </div>
			        <br/>
			    </c:forEach>			      
            </div>
            <!--版权
			<jsp:include page="user/bottom.jsp"></jsp:include>	-->
   		</div>
    </div>
	<!-- <div style="position:absolute; z-index:-1; width:100%; height:120px; background:#EAEAEA; bottom:0px;"> -->
  </body>
</html>
