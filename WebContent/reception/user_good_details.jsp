<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>农产品展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="./css/user_good.css"/>
	<script src="./js/user_good.js"></script>
  </head>
  
  <body>
    <div style="height:35px;;width:100%;border-bottom:1px solid #CCC; z-index:-1; position:absolute; background:#EFEFEF;"></div>
	<div style="width:1200px;margin:auto;">
		<!--登录状态-->
		<% if(session.getAttribute("user") == null){%>
			<input type="hidden" id="loginState" value="0">
		<%}else{%>
			<input type="hidden" id="loginState" value="1">
		<%}%>
		<!--登录窗口-->
		<div style="background:#FFF; border:1px solid #EDEDED; width:360px; height:320px; position:fixed; z-index:11; margin:150px 420px; box-shadow:0px 0px 1px #666; display:none;" id="login">
			<div style="background:#C30; height:50px; color:#FFF; font-weight:bold; font-size:26px; line-height:50px;">&nbsp;浪美时尚.COM
				<div class="close" id="closeLogin" style="color:#FFF; font-size:13px;">×</div>
			</div>
			<div id="errmsg2" class="loginErrMsg">${requestScope.errMsg }</div>
			<div style="position:absolute; margin:38px 40px;">
				<form action="UserGoodServlet.do?op=login" method="post">
					<input type="hidden" name="goodId" value="${requestScope.good.id }">
					<div style="font-weight:bold; font-size:15px;">账号</div>
					<div>
						<input type="text" name="userName" style="width:280px; height:30px; padding-left:5px;" placeholder="请输入用户名"/>
					</div>
					<div style="font-weight:bold; font-size:15px; padding-top:20px;">密码</div>
					<div>
						<input type="password" name="pwd" style="width:280px; height:30px; padding-left:5px;" placeholder="请输入密码"/>
					</div>
					<div style="padding-top:42px;">
						<input type="submit" style="background:#C30; width:280px; height:38px; border:none; font-size:20px; font-weight:bold; color:#FFF;" value="登录"/>
					</div>
				</form>
			</div>
		</div>
    	<!--顶部索引-->
		<% if(session.getAttribute("user") == null){%>
			<jsp:include page="user/top.jsp"></jsp:include>
		<%}else{ %>
			<jsp:include page="user/top2.jsp"></jsp:include>
		<%} %>
        <div class="header">		
            
            <div class="logo">
                <a href="UserIndexServlet.do"><img src="./images/util/logo.jpg" width="135px" height="108px" title="浪美时尚网络商城网"/></a>
            </div>
            <!--搜索框-->
            <div class="search_bar">
                <br />
                <br />
                <form method="post" action="#">
                    <input type="text" style="height:36px; width:380px; border:3px solid #C00; padding-left:5px;" placeholder="请输入商名称"/><input type="button" style="height:36px; width:80px; background:#C00; vertical-align:top; border:0px solid #C00; color:#FFF; font-size:18px; font-weight:bold; cursor:pointer;" value="搜索"/>
                </form>
                <table style="font-size:13px; color:#666;">
                    <tr height="28px">
                        <td width="100px"><br></td>
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
                    <span class="goodcar_span"></span>
                    <div class="goodcar_2"><br /><br /><br />农产品收藏夹空空如也，快来收藏点东西吧~</div>
                </div>
            </div>	
            <div class="nav">
            	<ul>
                	
                    
                </ul>
            </div>
		</div> 		
        <div style="height:8px;"></div>
        <!--商品购物信息-->
        <div class="main">
        	<!--商品图片-->
        	<div class="main_left">
                <!--放大镜-->
                <div id="demo">
                    <div id="small-box">
                        <div id="mark"></div>
                        <div id="float-box"></div>
                        <img src="${requestScope.good.picurl }" width="400" height="255"/>
                    </div>
                    <div id="big-box">
                        <img src="${requestScope.good.picurl }" width="1024" height="654"/>
                    </div>
                </div>
                <!--商品小图-->
                <div class="smallprc"><img src="${requestScope.good.picurl }" width="100px" height="85px"/></div>
                <div class="smallprc"><img src="${requestScope.good.picurl }" width="100px" height="85px"/></div>
                <div class="smallprc"><img src="${requestScope.good.picurl }" width="100px" height="85px"/></div>
                <div class="smallprc"><img src="${requestScope.good.picurl }" width="100px" height="85px"/></div>
            </div>
            <!--商品信息-->
			<div class="main_middle">
            	<div class="middle">               	
                	<form action="UserGoodServlet.do?op=shoppingCar" method="post">
	                	<!--支付窗口-->
						
						<!--商品详细信息-->					
						<input type="hidden" name="goodId" value="${requestScope.good.id }">	
                    	<p style="font-weight:bold;">${requestScope.good.goodname }</p>
                        <p style="color:red; margin-top:3px;">小涵农产品展示网&nbsp;时令果蔬 保证当季新鲜</p>
                    	<div class="middle_price">
                        	<table border="0px" width="490px" height="80px">
                            	<tr height="20px">
                                	<td style="padding:8px 10px;" width="100px">市场价</td>
                                    <td>￥${requestScope.good.price }</td>
                                </tr>
                                <tr height="42px">
                                	<td style="padding-left:10px;">口味</td>
                                    <td style="font-size:20px; color:red; font-weight:bold;">${requestScope.good.taste }</td>
                                </tr>
                                
                                  <tr height="42px">
                                    <td style="padding-left:10px;">季节</td>
                                    <td style="font-size:20px;  font-weight:bold;">${requestScope.good.season }</td>
                                </tr>
                                  <tr height="42px">
                                    <td style="padding-left:10px;">产地</td>
                                    <td style="font-size:20px; font-weight:bold;">${requestScope.good.address }</td>
                                </tr>
                                  <tr height="42px">
                                    <td style="padding-left:10px;">外观</td>
                                    <td style="font-size:20px;  font-weight:bold;">${requestScope.good.look }</td>
                                </tr>
                            </table>
                        </div>
                        
                      
                        	
                        
                       	
                        	
                        </div>
                        <div style="margin-top:38px; text-align:center;">
                            <input type="submit" class="submit_goodcar" value="加入收藏夹" id="goodcar"/>
                        </div>
                  	</form>               
                </div>
            </div>
          
        </div> 
	</div>
  </body>
</html>
