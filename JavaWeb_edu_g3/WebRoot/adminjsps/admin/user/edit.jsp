<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>编辑</h1>
  <%--
  1. 显示errors --> 字段错误
  2. 显示异常错误
  3. 回显
   --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/AdminUserServlet?id=${user.id }'/>" method="post">
    <input type="hidden" name="method" value="edit"/>
    用户名：<input type="text" name="name" value="${user.name }"/>
    <span style="color: red; font-weight: 900">${errors.name }</span>
    <br/>
    密　码：<input type="password" name="password" value="${user.password }"/>
    <span style="color: red; font-weight: 900">${errors.password }</span>
    <br/>
    性　别：<input type="text" name="sex" value="${user.sex }"/>
    <br/>
    年　龄：<input type="text" name="age" value="${user.age }"/>
    <br/>
    标　识：<input type="text" name="mark" value="${user.mark }"/>
    <br/>
    <input type="submit" value="确定"/>
</form>
  </body>
</html>
