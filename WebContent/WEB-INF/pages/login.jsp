<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin:0px;
	padding:0px;
	background:#eeeeee;
	text-align:center;
	font-size: 14px;
}

.main {
	margin-top:150px;
	margin-left:250px;
	padding:20px;
	width:240px;
	height:95px;
	background:#aaaaaa;
	text-align:center;
}
</style>
</head>
<body>
	<s:if test="#session.person!=null">
		<meta http-equiv="Refresh" content="1;url=${pageContext.request.contextPath }/pm/main_main">
	</s:if>
	
	<div class="main">
		<center>登录</center>
		<s:form namespace="/pm" action="login_find" id="login" name="login" theme="simple">
			<s:hidden value="login" name="hidden"></s:hidden><br />
			姓名：<s:textfield id="name" name="name" label="姓名" /><br />		
			密码：<s:password id="password" name="password" label="密码" /><br />
			<div style="text-align: center;"><s:submit type="input" value="登录"></s:submit><s:submit type="reset" value="重置"></s:submit></div>
		</s:form>
	</div>
	<s:fielderror></s:fielderror>
</body>
</html>