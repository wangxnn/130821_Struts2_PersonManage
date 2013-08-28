<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.head{
		background-color: #ACD6FF;
	}
	.title{
		background-color: #ACD6FF;
	}
</style>
</head>
<body>
	<div align="center" class="head"><h2>查看员工信息</h2></div>
	<table width="100%">
		<tr>
			<td class="title">登录名：</td>
			<td><s:property value="#request.person.loginName" /></td>
			<td class="title">用户名：</td>
			<td><s:property value="#request.person.userName" /></td>
		</tr>
		<tr>
			<td class="title">性别：</td>
			<td><s:property value="#request.person.sex" /></td>
			<td class="title">学历：</td>
			<td><s:property value="#request.person.education" /></td>
		</tr>
		<tr>
			<td class="title">出生日期：</td>
			<td><s:property value="#request.person.birthday" /></td>
			<td class="title">电话：</td>
			<td><s:property value="#request.person.telephone" /></td>
		</tr>
		<tr>
			<td class="title">兴趣爱好：</td>
			<td colspan="3"><s:property value="#request.person.interest" /></td>
		</tr>
		<tr>
			<td class="title">简历资料：</td>
			<td><s:property value="#request.person.filename" /></td>
		</tr>
		<tr>
			<td class="title">备注：</td>
			<td><s:property value="#request.person.remark" /></td>
		</tr>
		<tr>
			<td colspan="4" align="right"><a href="${pageContext.request.contextPath }/pm/um_all" target="pane" class="title">返回</a></td>
		</tr>
	</table>
</body>
</html>