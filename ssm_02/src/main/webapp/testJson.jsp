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

<title>测试json数据交互</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>

<script type="text/javascript">

	function requestJson() {
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/requestJson.action',
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			data:'{"name":"测试1","price":12000}',
			success:function(data) {
				alert(data.name + "  " + data.price);
			}
		});
	}

	function responseJson() {
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/responseJson.action',
			dataType:'json',
			data:'name=测试2&price=18000',
			success:function(data) {
				alert(data.name + "  " + data.price);
			}
		});
	}
</script>


</head>

<body>
	<input type="button" onclick="requestJson()" value="发送json,接收json" />
	<br>

	<input type="button" onclick="responseJson()" value="发送非json,接收json" />
</body>
</html>
