<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery.jstree.js"></script>
<style type="text/css">
	.hidden {
		display:none;
	}
	.show {
		display:block;
	}
	#em{
		margin:0px;
		margin-left: 20px;
		color:olive;
		font-size: 13px;
	}
	#um{
		margin:0px;
		margin-left: 40px;
		color:olive;
		font-size: 13px;
	}
</style>
</head>

<body>
	<div>
		<div id="tree">
			<div>系统菜单</div>
				<br />
				<div id="em"><label id="la">+</label>员工管理</div>
				<div id="um"  class="hidden"><a href="${pageContext.request.contextPath }/pm/um_all" target="pane">用户管理</a></div>
		</div>
	</div>
	
	<script type="text/javascript">
		var em = document.getElementById("em");
		em.onclick = function(){
			var um = document.getElementById("um");
			um.className = (um.className=="hidden"?"show":"hidden");
			var la = document.getElementById("la");
			if(um.className == "show"){
				la.firstChild.nodeValue = "-";
			}else{
				la.firstChild.nodeValue = "+";
			}
		}

	</script>
</body>
</html>