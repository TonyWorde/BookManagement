<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>Login</title>
    <link rel="stylesheet" type="text/css" href="static/css/login.css">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <div id="content">
    <div class="login-header">
        <img src="img/logo.jpg">
    </div>
    <form action = "identity.view" method=post>
        <div class="login-input-box">
            <span class="icon icon-user"></span>
            <input type="text" name="username" placeholder="Please enter your id">
        </div>
        
        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" name="password" placeholder="Please enter your password">
        </div>
        
        <div align="center">
        <input type="radio" name="person" value="admin" checked />管理员
        <input type="radio" name="person" value="reader" />读者</br>
        </div>
        
        <div class="login-button-box">
        <button>Login</button>
   	 	</div>
    </form>
	</div>
  </body>
</html>