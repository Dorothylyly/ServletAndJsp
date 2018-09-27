<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script src="./js/marager_index.js"></script>

  </head>
  
  <body>
	<ul>
    	<li class="manager_nav" onclick="show(1)"><img src="./images/managerindex/user.png" width="20px" height="16px"/>&nbsp;用户管理</li>
       	<div class="hidden" id="manager1">
        	<ul>
            	<li><a href="backstage/manager_user_add.jsp">添加用户</a></li>
                <li><a href="backstage/manager_user_del.jsp">删除用户</a></li>
                <li><a href="User.do?op=findAll">查看用户</a></li>
            </ul>
        </div>
        <li class="manager_nav" onclick="show(2)"><img src="./images/managerindex/good.png" width="20px" height="16px"/>&nbsp;商品管理</li>
       	<div class="hidden" id="manager2">
        	<ul>
            	<li><a href="backstage/manager_good_add.jsp">添加商品</a></li>
                <li><a href="Good.do?op=first">查看商品</a></li>
            </ul>
        </div>
        <li class="manager_nav" onclick="show(3)"><img src="./images/managerindex/indent.png" width="20px" height="16px"/>&nbsp;订单管理</li>
        <div class="hidden" id="manager3">
        	<ul>
                <li><a href="Indent.do?op=first">查看订单</a></li>
            </ul>
        </div>
        <li class="manager_nav" onclick="show(4)"><img src="./images/managerindex/manager.png" width="20px" height="16px"/>&nbsp;管理员管理（超级）</li>
        <div class="hidden" id="manager4">
        	<ul>
            	<li><a href="backstage/manager_manager_add.jsp">添加管理员</a></li>
                <li><a href="backstage/manager_manager_del.jsp">删除管理员</a></li>
                <li><a href="Manager.do?op=findAll">查看管理员</a></li>
            </ul>
        </div>
        <li class="manager_nav" onclick="show(5)"><img src="./images/managerindex/system.png" width="20px" height="16px"/>&nbsp;系统管理</li>
        <div class="hidden" id="manager5">
        	<ul>
            	<li><a href="backstage/manager_uppwd.jsp">修改密码</a></li>
            </ul>
        </div>
    </ul>
  </body>
</html>
