<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Values.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
  <head>
    <meta charset="TUF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
    <link rel="shortcut icon" href="./static/ico/favicon.png">
    <title>所有读者信息</title>

    <!-- Bootstrap core CSS -->
    <link href="./static/css/bootstrap.css" rel="stylesheet">
	<link href="./static/css/navbar-fixed-top.css" rel="stylesheet">
	<link href="./static/css/styles2.css" rel="stylesheet">
  </head>

  <body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="AdministerPage.jsp">图书馆后台系统</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="AdministerPage.jsp">首页</a></li>
            <li><a href="books.view">查看所有书籍</a></li>
            <li class="active"><a href="readers.view">查看所有读者</a></li>
            <li><a href="borrows.view">查看所有借阅信息</a></li>
            <li><a href="login.jsp">退出登录</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
    
    <table border="0.1" align="center" class="content1">
    <c:forEach var="re" items="${sessionScope.readers}">
    	<tr>
    		<td>姓名：${re.getRe_name()}</td>
    		<td>性别：${re.getRe_sex()}</td>
    		<td>ID：${re.getRe_id()}</td>
    		<td>密码：${re.getRe_pwd()}</td>
    		<td>联系方式：${re.getRe_phone()}</td>
    		<td>已借书数量：${re.getRe_yjys()}</td>
    		<td>剩余借阅数：${re.getRe_syjys()}</td>
    	</tr>
    </c:forEach>
    
    </table>
    
    <script src="./static/js/jquery-2.1.1.min.js"></script>
    <script src="./static/js/bootstrap.min.js"></script>
    
  </body>
</html>
