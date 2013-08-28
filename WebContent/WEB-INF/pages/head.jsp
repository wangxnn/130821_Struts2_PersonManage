<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.10.2.js"></script>
</head>
<body>
		<div style="text-align: center;font-size: 36px;">人员管理系统</div>
		<div id="showtime"></div>
		<script type="text/javascript">
			var d = new Date();
			$("#showtime").text(d.toLocaleDateString() + "星期" + (d.getDay()>0?d.getDay():"日") );
		</script>
</body>
</html>
