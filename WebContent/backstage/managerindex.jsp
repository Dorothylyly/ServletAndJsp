<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
   
  	<title>浪美时尚网络商城-后台管理</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="./css/manager_index.css"/>
	<script src="./js/marager_index.js"></script>
	<script src="./js/manager_util.js"></script>
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
	    	<jsp:include page="manager/right.jsp"></jsp:include>  
	    	<div class="bottom">
				Copyright© 浪美时尚网上商城 2007-2015，All Rights Reserved
 			</div>
	    </div>
    </div>

</body>
</html>