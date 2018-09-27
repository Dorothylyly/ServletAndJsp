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
    
    <title>浪美时尚后台-订单详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
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
	</style>

  </head>
  
	<body>
		<div class="top_index">
			<jsp:include page="manager/top.jsp"></jsp:include>
		</div>
		<div class="middle">
			<div class="middle_menu" style="height:800px;">
				<jsp:include page="manager/left.jsp"></jsp:include>    		
			</div>
			<div class="middle_right">
				<div class="middle_index">
					<div class="index_titlename">商品详情</div>
					<div class="middle_search">
						<jsp:include page="manager/search.jsp"></jsp:include>
					</div>
				</div>
				<div class="middle_main">
					<div class="middle_adduser">
					    <table border="1px" cellspacing="0px" bordercolor="#FFF" width="540px">
					    	<tr height="32px;">
					    		<td colspan="2">&nbsp;${indent.actionid }</td>
					    	</tr>
					    	<tr>
					    		<td rowspan="2" align="center" width="160px"><img src="${indent.picurl }" width="80px" height="80px"/></td>
					    		<td height="46x">&nbsp;${indent.goodname }</td>
					    	</tr>
					    	<tr>
					    		<td>&nbsp;用户：${indent.username }</td>
					    	</tr>
					       	<tr height="42px">
						       <td>&nbsp;市场价：</td>
						       <td>&nbsp;${indent.price }</td>
					       	</tr>
					       	<tr height="42px">
						       <td>&nbsp;会员价：</td>
						       <td>&nbsp;${indent.memberprice }</td>
					       	</tr>		
					       	<tr height="42px">
						       <td>&nbsp;数量：</td>
						       <td>&nbsp;${indent.productnum }</td>
					       	</tr>
					       	<tr height="42px">
						       <td>&nbsp;上架日期：</td>
						       <td>&nbsp;${indent.actiondate }</td>
					       	</tr>
					       	<tr height="42px">
						       <td>&nbsp;状态：</td>
						       <td>&nbsp;${indent.state }</td>
					       	</tr>					       						       						       						       						       						       	
					       	<tr height="40px">
					       		<td>&nbsp;收货人：</td>
					       		<td>&nbsp;${indent.relname }</td>
					       	</tr>
					       	<tr height="40px">
					       		<td>&nbsp;收货人移动电话：</td>
					       		<td>&nbsp;${indent.mobile }</td>
					       	</tr>
					       	<tr height="40px">
					       		<td>&nbsp;收货地址：</td>
					       		<td>&nbsp;${indent.address }</td>
					       	</tr>
					       	<tr height="40px">
					       		<td>&nbsp;邮编：</td>
					       		<td>&nbsp;${indent.postcode }</td>
					       	</tr>
					       	<tr height="40px">
					       		<td>&nbsp;总金额：</td>
					       		<td>&nbsp;${indent.total }</td>
					       	</tr>						       						       					       						       					    				  					     						        
					        <tr height="52px" align="center">
					            <td colspan="3"><input type="button" value="返回" class="submit" id="submit"/></td>
					        </tr>
					    </table>
					</div>
				</div>
			 </div>
		</div>
		<script src="./js/manager_user_add.js"></script>
	</body>
</html>
