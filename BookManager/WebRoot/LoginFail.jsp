<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
	  <head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
		<link rel="shortcut icon" href="./static/ico/favicon.png">

		<title>登录失败</title>

		<!-- Bootstrap core CSS -->
		<link href="./static/css/bootstrap.css" rel="stylesheet">
		<link href="./static/css/navbar-fixed-top.css" rel="stylesheet">
		<link href="./static/css/login.css" rel="stylesheet">
		<link href="./static/css/styles.css" rel="stylesheet">
	  </head>
  
  <body>
    <div id="content">
    <div class="login-header">
        <img src="img/logo.jpg">
    </div>
    </br>
    <h3 align="center">登录失败</h3></br>
    <h4 align="center">用户名或密码不正确</h4></br>
    <h4 align="center"><a href="login.jsp">重新登录</a></h4>
    
	</div>
  </body>
</html>
