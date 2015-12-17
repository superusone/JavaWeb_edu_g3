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
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function _change(){
			var imgEle = document.getElementById("img");
			imgEle.src = "<c:url value='/VerifyCodeServlet?a='/>" + new Date().getTime();
		}
	</script>

  </head>
  
  <body>
  <h1>注册</h1>
  <%--
  1. 显示errors --> 字段错误
  2. 显示异常错误
  3. 回显
   --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServlet'/>" method="post">
    <input type="hidden" name="method" value="regist"/>
    用户名：<input type="text" name="name" value="${form.name }"/>
    <span style="color: red; font-weight: 900">${errors.username }</span>
    <br/>
    密　码：<input type="password" name="password" value="${form.password }"/>
    <span style="color: red; font-weight: 900">${errors.password }</span>
    <br/>
    性　别：<input type="text" name="sex" value="${form.sex }"/>
    <span style="color: red; font-weight: 900">${errors.sex }</span>
    <br/>
    年　龄：<input type="text" name="age" value="${form.age }"/>
    <span style="color: red; font-weight: 900">${errors.age }</span>
    <br/>
    验证码：<input type="text" name="verifyCode" size="3"/>
	 <img id="img" src="<c:url value='/VerifyCodeServlet'/>">
	 <a href="javascript:_change()">换一张</a>
	 <span style="color: red; font-weight: 900">${errors.verifyCode }</span>
	 <br/>
    <input type="submit" value="注册"/>
</form>
  </body>
</html>
