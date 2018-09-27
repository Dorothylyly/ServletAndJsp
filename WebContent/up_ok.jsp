<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码-修改成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta http-equiv="refresh" content="4;url=userlogin.jsp"/>
	
	<link rel="stylesheet" type="text/css" href="./css/user_forgetpwd.css">
	<script src="./js/user_forgetpwd.js"></script>

  </head>
  
  <body onload="jump()">
	<div style="height:105px;width:100%;border-bottom:1px solid #CCC; z-index:-1; position:absolute; background:#FFFFFF;"></div>
	<div style="width:1200px; margin:auto;">
    	<!--顶部索引-->
    	<div class="header">
			<!--logo-->
			<div class="header_left"><a href="UserIndexServlet.do"><img src="./images/util/logo.jpg" width="100px" height="80px" align="absbottom" title="涵小涵农产品展示网"/></a>|找回密码</div>
			<div class="header_right">您好，欢迎涵小涵农产品展示网！&nbsp;<a href="userlogin.jsp">请登录</a></div>
		</div>
        <div style="height:35px;"></div>
		<!--中间主体-->
        <div class="middle">
        	<div style="width:880px; height:380px; margin:auto; margin-top:38px;">
            	<!--1、2、3流程-->
            	<div style="height:70px; border-bottom:1px solid #CCC;">
                	<div class="middle_line" style="margin-left:170px; background:#C00;"></div>
                	<div class="middle_one" style="background:#C00; border:1px solid #C00; color:#FFF;">1</div>                    
                    <div class="middle_line" style="background:#C00;"></div>
                    <div class="middle_two" style="background:#C00; border:1px solid #C00; color:#FFF;">2</div>
                    <div class="middle_line" style="background:#C00;"></div>
                   	<div class="middle_three" style="background:#C00; border:1px solid #C00; color:#FFF;">3</div>
                    <div class="middle_line" id="line" style="background:#C00;"></div>
                </div>
                <!--修改成功-->
				<div style="border-top:1px solid #CCC; height:310px; width:880px; color:#333; text-align:center; padding-top:120px;">                
                    <h2>密码修改成功！</h2>
                    <h3><a href="userlogin.jsp" style="color:#333;">系统将在<span id="time">4</span>秒后自动跳转到登录页面。如未跳转，请点击本链接跳转。</a></h3>
                </div>
            </div>
        </div>
    	<!--版权信息-->
		<div class="footer">
        	<br />
            <br />
			&nbsp;<a href="#" target="_blank">关于我们</a>&nbsp;|&nbsp;<a href="#" target="_blank">联系我们</a>&nbsp;|&nbsp;<a href="#" target="_blank">商家入驻</a>&nbsp;|&nbsp;<a href="#" target="_blank">营销中心</a>&nbsp;|&nbsp;<a href="#" target="_blank">友情链接</a>&nbsp;|&nbsp;<a href="#" target="_blank">涵小涵农产品社区</a>&nbsp;<br />
			Copyright© 涵小涵农产品展示网，All Rights Reserved
		</div>
    </div> 
  </body>
</html>
