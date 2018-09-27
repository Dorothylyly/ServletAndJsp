<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
		<div class="top" id="top">
			<div class="top_left">您好！欢迎光临小涵农产品展示网！&nbsp;&nbsp;&nbsp;
				<a href="reception/user_personal.jsp" style="color:#2894FF;">${sessionScope.user.username }</a>&nbsp;&nbsp;&nbsp;
				<a href="UserIndexServlet.do?op=quit" style="color:#888;">退出</a>
			</div>
            <div class="top_right">
            	<ul>
                	<li class="top_ulli">
                    	<a href="#"><span>农产品展示 ˇ</span></a>
                    	
                    </li>
                    <li class="top_ulli">
                    	<a href="#"><span>收藏夹  ˇ</span></a>
                       
                   	</li>
                    
                    <li class="top_ulli">
                    	<a href="#"><span>客服服务  ˇ</span></a>
                       
                    </li>
                    
            	</ul>
        	</div>
		</div>
  </body>
</html>
