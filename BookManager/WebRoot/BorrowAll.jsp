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
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
		<link rel="shortcut icon" href="./static/ico/favicon.png">

		<title>借阅信息</title>

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
          <a class="navbar-brand" href="ReaderPage.jsp">Java小组图书馆</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="ReaderPage.jsp">首页</a></li>
            <li><a href="BookQuery.jsp">查找书籍</a></li>
            <li><a href="BorrowQuery.jsp">借书</a></li>
            <li class="active"><a href="borrowall.view">查看借阅信息</a></li>
            <li><a href="returnall.view">还书</a></li>
            <li><a href="reader.view">查看个人信息</a></li>
            <li><a href="login.jsp">退出登录</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    

  <table border="0.1" align="center" class="content1">
    <c:forEach var="borr" items="${sessionScope.borrow }">
    	<tr>
    		<td><img src="${borr.getBr_img()}" width="80px" height="80px"/></td>
    		<td>书名：${borr.getBr_name()}</td>
    		<td>${borr.getBr_author()} 著</td>
    		<td>借阅：${borr.getBr_num()} 本</td>
    	</tr>
    </c:forEach>
    
    </table>
    
    <script src="./static/js/jquery-2.1.1.min.js"></script>
    <script src="./static/js/bootstrap.min.js"></script>
    
  </body>
</html>
