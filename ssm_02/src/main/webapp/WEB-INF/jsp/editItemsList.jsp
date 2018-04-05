<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript">
	/* 执行查询 */
	function queryItems() {
		document.queryAndDeleteForm.action = "${pageContext.request.contextPath }/items/queryItems.action";
		document.queryAndDeleteForm.submit();
	}
	
	/* 批量更新 */
	function modifyItemsList() {
		document.queryAndDeleteForm.action = "${pageContext.request.contextPath }/items/testMap.action";
		document.queryAndDeleteForm.submit();
	}
</script>
</head>
<body> 
<form name="queryAndDeleteForm" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td width="30%"><input type="text" name="itemsCustom.name"></td>
<td><input type="button" value="查询" onclick="queryItems()"/></td>
<td><input type="button" value="批量更新" onclick="modifyItemsList()"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>隐藏id</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemsList }" var="item" varStatus="status">
<tr>
	<%-- <td><input type="hidden" name="itemsCustomList[${status.index }].id" value="${item.id}"></td>
	<td><input type="text" name="itemsCustomList[${status.index }].name" value="${item.name}"></td>
	<td><input type="text" name="itemsCustomList[${status.index }].price" value="${item.price}"></td>
	<td><input type="text" name="itemsCustomList[${status.index }].createtime" value='<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>'></td>
	<td><input type="text" name="itemsCustomList[${status.index }].detail" value="${item.detail}"></td> --%>
	
	<td><input type="hidden" name="testMap['id' + ${status.index}]" value="${item.id}"></td>
	<td><input type="text" name="testMap['name' + ${status.index}]" value="${item.name}"></td>
	<td><input type="text" name="testMap['price' + ${status.index}]" value="${item.price}"></td>
	<td><input type="text" name="testMap['createtime' + ${status.index}]" value='<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>'></td>
	<td><input type="text" name="testMap['detail' + ${status.index}]" value="${item.detail}"></td>
	
	
	<td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>