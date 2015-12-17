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
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
  <!-- 未处理分页 -->>
   <h3 align="center">列表</h3>
<table border="1" width="70%" align="center">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>mark</th>
    </tr>
<%--
要遍历提UserList这个集合
 --%>
<c:forEach items="${UserList}" var="user">
    <tr>
        <td>${user.name }</td>
        <td>${user.sex }</td>
        <td>${user.age }</td>
        <td>${user.mark }</td>
        <td>
            <a href="<c:url value='/AdminUserServlet?method=preEdit&id=${user.id }'/>">编辑</a>
            <a href="<c:url value='/AdminUserServlet?method=delete&id=${user.id }'/>">删除</a>
        </td>
    </tr>
</c:forEach>
</table>
<br/>
  </body>
</html>
