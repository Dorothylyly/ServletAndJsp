<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="com.util.*,java.net.*"%>

<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
  	String adminName = "";
    String adminPwd = "";
    Cookie[] cookie = request.getCookies();
    if(cookie != null && cookie.length > 0){
		for(Cookie c: cookie){
			if(c.getName().equals("adminName")){
				adminName = URLDecoder.decode(c.getValue(),"utf-8");
			}
			if(c.getName().equals("adminPwd")){
				adminPwd = URLDecoder.decode(c.getValue(),"utf-8");
			}	
		}						
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	 	<base href="<%=basePath%>">
	   
	   	<title>浪美时尚网络商城-后台登陆</title>
	   
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<link type="text/css" href="./css/manager_login.css" rel="stylesheet" />
	</head>
  
	<body bgcolor="#222222">
		<div class="top_index">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;浪美时尚网络商城网后台管理系统</div>
		<div style="margin:auto; width:1200px;">
	    	<div class="main">
	        	<div class="top">管理员登录</div>
	            <form action="ManagerLogin.do" method="post" name="myform">
	                <div class="username">
	                    账号：<input type="text" id="managerName" name="managerName" class="usernamepwd" placeholder="请输入账号" value="<%=adminName %>"/>
	                </div>
	                <div class="pwd">
	                    密码：<input type="password" id="managerPwd" name="managerPwd" class="usernamepwd" placeholder="请输入密码" value="<%=adminPwd %>"/>
	                </div>
	                <div class="twopwd">
	                    <div class="rememberpwd">
	                        <input type="checkbox" id="rememberPwd" name="rememberPwd" checked="checked"/><span>记住密码</span>
	                    </div>
	                    <div class="forgetpwd">
	                    	<a href="../../../GoodsSale/GoodsSale/webpage/forgetpwd_userName.html" target="_blank"><span>忘记密码？</span></a>
	                    </div>
	                </div>
	                <div class="submit">
	                    <input type="submit" class="bottom_submit" value="登录"/>
	                </div>
	        	</form>
	        </div>
	       	<div class="bottom">
    			<br />
				<br />
				<br />
				&nbsp;<a href="#" target="_blank">关于我们</a>&nbsp;|&nbsp;<a href="#" target="_blank">联系我们</a>&nbsp;|&nbsp;<a href="#" target="_blank">商家入驻</a>&nbsp;|&nbsp;<a href="#" target="_blank">营销中心</a>&nbsp;|&nbsp;<a href="#" target="_blank">友情链接</a>&nbsp;|&nbsp;<a href="#" target="_blank">浪美时尚社区</a>&nbsp;<br />
				Copyright© 浪美时尚网上商城 2007-2015，All Rights Reserved
    		</div>
	    </div>
	</body>
</html>
