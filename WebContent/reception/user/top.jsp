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
			<div class="top_left">您好！欢迎来农产品展示平台！&nbsp;&nbsp;&nbsp;<a href="reception/userlogin.jsp">请登录</a>&nbsp;&nbsp;&nbsp;<a href="reception/userregister.jsp">免费注册</a></div>
            <div class="top_right">
            	<ul>
                	<li class="top_ulli">
                    	<a href="#"><span>我的农产品展示平台 ˇ</span></a>
                    	<div class="top_index">
                        	<div style="height:20px; margin-top:13px;"><span>我的农产品展示平台 ˇ</span>
                            	
                            </div>
                        </div>
                    </li>
                    <li class="top_ulli">
                    	<a href="#"><span>收藏夹  ˇ</span></a>
                        <div style="margin-left:-2px" class="top_index">
                        	<div style="height:20px; margin-top:13px;"><span>收藏夹  ˇ</span>
                           		
                            </div>
                    	</div>
                   	</li>
                    <li class="top_ulli">
                    	<a href="#"><span>关注农产品展示平台  ˇ</span></a>
                        <div class="top_index" style="margin-left:-2px">
                        	<div style="height:20px; margin-top:13px;"><span>关注农产品展示平台  ˇ</span>
                            	
                            </div>
                        </div>
                   	</li>
                    <li class="top_ulli">
                    	<a href="#"><span>客服服务 ˇ</span></a>
                        <div class="top_index" style="margin-left:-2px">
                        	<div style="height:20px; margin-top:13px;"><span>客服服务  ˇ</span>
                            	
                            </div>
                        </div>
                    </li>
                    <li class="top_ulli">
                    	<a href="#"><span>网站导航  ˇ</span></a>
                    	<div class="top_index" style="margin-left:-2px; border:none;">
                        	<div style="height:20px; margin-top:13px;"><span>网站导航  ˇ</span></div>
                        </div> 
                        <div style="width:1200px; position:relative; left:-1117px; top:33px; height:180px;" class="top_index">
                        	<br/>
                        	<br/>
                        	<a href="http://localhost:10000/jspAndServlet/ManagerLogin.do">农产品展示平台后台管理系统</a>
                        </div>
                    </li>
            	</ul>
        	</div>
		</div>
  </body>
</html>
