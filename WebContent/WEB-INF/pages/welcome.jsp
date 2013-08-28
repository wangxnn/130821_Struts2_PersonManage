<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.head{
		background-color: #ACD6FF;
	}
	.evenClass{
		background-color: #ACD6FF;
	}
	.oddClass{
		background-color: #AAAAFF;
	}
</style>
</head>
<body>
<div class="head">查询条件</div>
<table width="100%">
	<s:form namespce="" action="" method="post" theme="simple" id="form1">
		<tr>
			<td>用户姓名：<s:textfield name="name" id="name" ></s:textfield></td>		
			<td>
					性别：<s:select list="#{'01':'请选择', '02':'男', '03':'女'}" name="gender" listKey="key" 
										listValue="value" value="01"></s:select>
			</td>		
		</tr>
		
		<tr>
			<td>
					学历：<s:select list="#{'01':'请选择', '02':'幼儿园',  '03':'小学', '04':'初中', '05':'本科', '06':'硕士', '07':'博士'}"
									name="education" listKey="key" listValue="value" value="01"></s:select></td>		
			<td>
					是否上传简历：<s:select list="#{'01':'请选择',  '02':'是', '03':'否'}"
								name="hasimg" listKey="listKey" listValue="value" value="01"></s:select>
			</td>		
		</tr>
		
		<tr>
			<td colspan="2" align="right">
				<s:submit type="input" value="查询"></s:submit>
				<s:reset type="button" value="重置"></s:reset>
			</td>
		</tr>
	</s:form>	
</table>
<hr />
<div class="head">用户列表</div>
<div align="right"><a href="${pageContext.request.contextPath }/pm/addUI">添加</a></div>
<table width="100%">
	<tr class="head">
		<th>登录名</th>
		<th>用户名</th>
		<th>性别</th>
		<th>联系电话</th>
		<th>学历</th>
		<th>编辑</th>
		<th>查看</th>
		<th>删除</th>
	</tr>
	<s:iterator value="#request.page.list" var="p" status="st">
		<tr class="<s:property value="#st.even?'evenClass':'oddClass' "/>">
			<td><s:property value="#p.loginName"  /></td>
			<td><s:property value="#p.userName" /></td>
			<td><s:property value="#p.sex" /></td>
			<td><s:property value="#p.telephone" /></td>
			<td><s:property value="#p.education" /></td>
			<td><a href="${pageContext.request.contextPath }/pm/um_editUI?userID=<s:property value='#p.userID' />">编辑</a></td>
			<td><a href="${pageContext.request.contextPath }/pm/um_checkUI?userID=<s:property value='#p.userID' />">查看</a></td>
			<td><a href="${pageContext.request.contextPath }/pm/um_del?userID=<s:property value='#p.userID' />">删除</a></td>
		</tr>
	</s:iterator>
</table>
<div align="right">
	<s:iterator value="#request.page.pageBar" var="bar">
		<a href="${pageContext.request.contextPath }/pm/um_all?currentPage=<s:property value='#bar' />" target="pane"><s:property value="#bar" /></a>
	</s:iterator>
</div>
</body>
</html>