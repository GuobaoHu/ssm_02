<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录页面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
		function testPageContext() {
			alert(${pageContext.request.contextPath });
		}
		
	</script>
</head>

<body>
	<script type="text/javascript">
		testPageContext();
	</script>
	<form action="${pageContext.request.contextPath }/login.action" method="post">
		username:<input name="username" type="text"/>
		<br>		
		password:<input name="password" type="password"/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>
