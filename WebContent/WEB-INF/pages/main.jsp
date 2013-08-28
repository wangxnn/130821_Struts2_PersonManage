<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<frameset rows="20%,*" border="2px solid #ffffff;">
	<frame name="head" src="${pageContext.request.contextPath }/pm/main_head"></frame>
	<frameset cols="21%,*">
		<frame name="left" src="${pageContext.request.contextPath }/pm/main_left"></frame>
		<frame name="pane" src="${pageContext.request.contextPath }/pm/main_pane"></frame>
	</frameset>
</frameset>
</html>