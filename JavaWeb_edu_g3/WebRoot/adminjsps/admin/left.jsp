<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>菜单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<c:url value='/menu/mymenu.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/menu/mymenu.css'/>" type="text/css" media="all">
<script language="javascript">
/*
 * bar1：必须与对象名相同！
 */
var bar1 = new Q6MenuBar("bar1", "XXX考试考务");
function load() {
	/*
	设置本色方案！
	配置方案一共4种：0、1、2、3
	*/
	bar1.colorStyle = 2;
	/*
	指定图片目录
	*/
	bar1.config.imgDir = "<c:url value='/menu/img/'/>";
	/*
	菜单之间是否相互排斥
	*/
	bar1.config.radioButton=true;
	/*
	分类管理：指定要添加的菜单名称（如果这个名称的菜单已经存在，不会重复添加）
	查看分类：指定要添加的菜单项名称
	<c:url value='/adminjsps/admin/category/list.jsp'/>：指定菜单项时要请求的地址
	body：结果的显示框架页名称
	*/
	bar1.add("试卷管理", "查看试卷", "<c:url value='/admin/AdminCategoryServlet?method=findAll'/>", "body");
	bar1.add("试卷管理", "添加试卷", "<c:url value='/adminjsps/admin/paper/add.jsp'/>", "body");
	bar1.add("试卷管理", "删除试卷", "<c:url value='/adminjsps/admin/paper/delete.jsp'/>", "body");

	bar1.add("学生管理", "查看所有", "<c:url value='/AdminUserServlet?method=findAll&mark=2'/>", "body");
	bar1.add("学生管理", "添加学生", "<c:url value='/adminjsps/admin/user/add.jsp?mark=2'/>", "body");

	bar1.add("教师管理", "查看所有", "<c:url value='/AdminUserServlet?method=findAll&mark=1'/>", "body");
	bar1.add("教师管理", "添加教师", "<c:url value='/adminjsps/admin/user/add.jsp?mark=1'/>", "body");

	// 获取div元素
	var d = document.getElementById("menu");
	// 把菜单对象转换成字符串，赋给<div>元素做内容
	d.innerHTML = bar1.toString();
}
</script>

</head>

<body onload="load()" style="margin: 0px; background: rgb(254,238,189);">
<div id="menu"></div>

</body>
</html>
