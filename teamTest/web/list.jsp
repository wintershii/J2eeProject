<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/14
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table border="2">
    <tr>
        <td>商品名称</td>
        <td>商品类型</td>
        <td>商品产地</td>
        <td>上架时间</td>
        <td>商品库存</td>
        <td>选择操作</td>
    </tr>
    <c:forEach items="${goods}" var="g">
        <tr>
            <td>${g.name}</td>
            <td>${g.gType}</td>
            <td>${g.location}</td>
            <td>${g.gDate}</td>
            <td>${g.gRest}</td>
            <td><a href="/delete?id=${g.id}" >删除</a> <a href="/update?id=${g.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
<br />
<form action="add.jsp" method="">
    <input type="submit" value="增加">
</form>
<form action="search.jsp" method="">
    <input type="submit" value="查找">
</form>
</body>
</html>
