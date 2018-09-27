<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="com.util.*,java.net.*"%>

<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	String userName = "";
	String userPwd = "";
	Cookie[] cookie = request.getCookies();
	if(cookie != null && cookie.length > 0){
		for(Cookie c: cookie){
			if(c.getName().equals("userName")){
				userName = URLDecoder.decode(c.getValue(),"utf-8");
			}
			if(c.getName().equals("userPwd")){
				userPwd = URLDecoder.decode(c.getValue(),"utf-8");
			}	
		}						
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录农产品展示平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="./css/user_login.css"/>
  </head>
  
  <body bgcolor="#F9F9F9">
	<div style="height:105px;width:100%;border-bottom:1px solid #CCC; z-index:-1; position:absolute; background:#FFFFFF;"></div>
	<div style="width:1100px;margin:auto;">
		<div class="header">
			<!--logo-->
			<div class="header_left"><a href="UserIndexServlet.do"><img src="./images/util/logo.jpg" width="100px" height="80px" align="absbottom" title="浪美时尚网络商城网"/></a>|欢迎登录</div>
			<div class="header_right">您好，欢迎光临小涵的农产品展示网！&nbsp;<a href="reception/userregister.jsp">免费注册</a></div>
		</div>
		<div class="main">
			<br />
			<br />
            <br />
			<!--左侧广告-->
			<div class="main_left"><img src="./images/login/login.jpg" width="100%" height="420px" title="涵小涵农产品主题"/></div>
			<!--右侧登录-->
			<div class="main_right">
				 <form action="UserLogin.do" method="post" name="form1">
					<div style="height:80px;">
						<div style="height:15px;"></div>
						<div id="msg" class="errmsg">${requestScope.errMsg}</div>
					</div>
					<div class="main_left_username">账号：</div>
					<div class="main_left_login">
						<input type="text" id="userName" name="userName" placeholder="用户名/邮箱/手机" style="width:100%; height:38px; padding-left:5px;" value="<%=userName %>"/>
					</div>
					<div style="height:20px;"></div>
					<div class="main_left_password">密码：</div>
					<div class="main_left_login">
						<input type="password" id="pwd" name="pwd" placeholder="密码" style="width:100%; height:38px; padding-left:5px;"  value="<%=userPwd %>"/>
					</div>
					<div style="height:20px;"></div>
					<div class="main_left_login">
						<div class="main_left_automaticLogon"><input type="checkbox" id="checkboxID" name="checkboxID" checked="checked"/>下次自动登录</div>
						<div class="main_left_forgetPassword"><a href="up_pwd_username.jsp" target="_blank">忘记密码？</a></div>
					</div>
					<div class="main_left_login">
						<input type="submit" style="width:100%; height:40px; background:#C00; color:#FFF; border:1px solid #F63; font-size:18px; font-weight:500; font-weight:bold;" value="登录"/>
					</div>
					<div style="height:35px;"></div>
					<hr  style="border:5px solid #EEE; width:80%; text-align:center;"/>
					<div style="text-align:left; margin-left:10%; font-size:14px;">
						
					</div>
				</form>
			</div>
		</div>
		<!--版权-->
		<div class="footer">
			&nbsp;<a href="#" target="_blank">关于我们</a>&nbsp;|&nbsp;<a href="#" target="_blank">联系我们</a>&nbsp;|&nbsp;<a href="#" target="_blank">商家入驻</a>&nbsp;|&nbsp;<a href="#" target="_blank">营销中心</a>&nbsp;|&nbsp;<a href="#" target="_blank">友情链接</a>&nbsp;|&nbsp;<a href="#" target="_blank">涵小涵农产品社区</a>&nbsp;<br />
			Copyright© 小涵的农产品展示网
		</div>
	</div>
	
	<script type="text/javascript">
		window.onload = function(){
			var errmsgText = document.getElementById("msg").innerText;
			var errmsg = document.getElementById("msg");

			if(errmsgText != "" && errmsgText != null){
				errmsg.style.display = 'block'
			}
		}
	</script>
  </body>
</html>
