<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	caption{
		background:#AAAAFF;
	}
	table{
		border: 1px solid #ffffff;
		background:#DDDDFF;
	}
</style>
</head>
<body>
	<div>
		<s:form namespace="/pm" action="um_update" method="post" theme="simple" enctype="multipart/form-data">
				<table>
					<caption>编辑用户</caption>
					<tr>
						<td colspan="2">登录名：<s:textfield name="loginName" id="loginName" label="loginName"  /></td>
					</tr>
					<tr>
						<td>密码：<s:password name="loginPwd" id="loginPwd" label="loginPwd" /></td>
						<td>用户名：<s:textfield name="userName" id="userName" label="password" /></td>
					</tr>
					<tr>
						<td>性别：<s:radio list="{'男', '女' }"  name="sex" /></td>
						<td>
								学历：<s:select list="{'请选择', '幼儿园',  '小学', '初中', '本科', '硕士', '博士'}" name="education"  />
						<td>
					</tr>
					<tr>
						<td>出生日期：<s:textfield name="birthday" id="birthday" label="birthday" /></td>
						<td>电话：<s:textfield name="telephone" id="telephone" label="telephone" /></td>
					</tr>
					<tr>
						<td colspan="2">兴趣爱好：<s:checkboxlist list="{'看电影',  '购物',  '健身',  '旅游',  '睡觉', '美食' }" name="interest"/></td>
					</tr>
					<tr>
						<td colspan="2">简历资料：<s:file name="uploadfile" id="uploadfile" /></td>
					</tr>
					<tr>
						<td colspan="2">备注：<s:textarea cols="80" row="5"  name="remark" id="remark" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<center>
									<s:submit type="input" name="confirm" value="确定" />
									<s:reset type="button" name="reset" value="重置" />
							</center>
						</td>
					</tr>
				</table>
				<s:hidden name="userID" id="userID"></s:hidden>
				<s:token />
				<s:fielderror />
		</s:form>
	</div>
</body>
</html>