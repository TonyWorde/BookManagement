<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>管理员主界面</title>

    <!-- Bootstrap core CSS -->
    <link href="./static/css/bootstrap.css" rel="stylesheet">
    <link href="./static/css/navbar-fixed-top.css" rel="stylesheet">
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
            <li class="active"><a href="AdministerPage.jsp">首页</a></li>
            <li><a href="books.view">查看所有书籍</a></li>
            <li><a href="readers.view">查看所有读者</a></li>
            <li><a href="borrows.view">查看所有借阅信息</a></li>
            <li><a href="login.jsp">退出登录</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
    
    <div class="container" >
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div class="thumbnail">
            <img src="img/001.jpg" alt="...">
            <div class="caption">
              <h3>感受阅读</h3>       
              <p>一个习惯阅读的人，一个有着坚定内心的人，其内心的力量是强大的。无论多么先进的武器，都不足以摧毁他们的内心。当轰炸机呼啸而来，当各类新式武器被普遍运用到人类的自相残杀中。当大街小巷几乎同时被炸成齑粉，总会有人在废墟上继续人类文明的事业。总会有一些人，在暗夜里点亮明灯，照亮黑暗，迎接黎明</p>
            </div>
          </div>
        </div>
        
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
          <img src="img/002.jpg" alt="...">
          <div class="caption">
            <h3>我的图书馆</h3>       
            <p>Java小组图书馆是吉林大学珠海学院计算机学院16级软件4班的学生李璧鑫、詹沂、叶关情、曾昌衡四人在郭晓燕老师、吴昊老师的指导教育下开发出来的一款软件，其宗旨不止为了完成作业，更重要的是为了引导广大吉珠学子多多去学校的图书馆学习</p>
            </br></br>
          </div>
        </div>
   	 </div>
	</div>
	</div>
    <script src="./static/js/jquery-2.1.1.min.js"></script>
    <script src="./static/js/bootstrap.min.js"></script>
  </body>
</html>