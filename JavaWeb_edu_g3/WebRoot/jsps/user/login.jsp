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
    
    <title>登录</title>
    
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
  <h1>登录</h1>
  
<%--
1. 显示错误信息
2. 回显
 --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServlet'/>" method="post">
    <input type="hidden" name="method" value="login"/>
    用户名：<input type="text" name="name" value="${form.name }"/><br/>
    密　码：<input type="password" name="password" value="${form.password }"/><br/>
    验证码：<input type="text" name="verifyCode" size="3"/>
	 <img id="img" src="<c:url value='/VerifyCodeServlet'/>">
	 <a href="javascript:_change()">换一张</a>
	 <br/>
    <input type="submit" value="登录"/>
</form>
  </body>
</html>
