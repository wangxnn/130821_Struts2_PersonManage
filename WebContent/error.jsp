<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--
	 <meta http-equiv="Refresh" content="3;url=${pageContext.request.contextPath }/index.jsp">
 -->
</head>
<body>
	<h1>错误显示页面</h1>
	<!-- 权限拦截的错误显示 -->
	${message }
	
	<!-- 数据重复提交的错误显示 -->
	<s:actionerror />
</body>
</html>