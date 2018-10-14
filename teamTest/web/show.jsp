<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/14
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找结果</title>
</head>
<body>
<table border="2">
    <tr>
        <td>商品名称</td>
        <td>商品类型</td>
        <td>商品产地</td>
        <td>上架时间</td>
        <td>商品库存</td>
    </tr>
    <c:forEach items="${list}" var="g">
        <tr>
            <td>${g.name}</td>
            <td>${g.gType}</td>
            <td>${g.location}</td>
            <td>${g.gDate}</td>
            <td>${g.gRest}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
