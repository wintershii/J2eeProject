<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/19
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>博客</title>
</head>
<body>
<%--<c:if var="" test="${}"/>--%>
<table border="1">
    <tr>
        <td>标题</td>
        <td>作者</td>
        <td>概览</td>
        <td>日期</td>
        <td>浏览量</td>
    </tr>
    <c:forEach items="${articleList}" var="a">
        <tr>
            <td><a href="<c:url value="articlePage?id=${a.id}"/>">${a.title}</a></td>
            <td>${a.author}</td>
            <td>${a.essay}</td>
            <td>${a.aDate}</td>
            <td>${a.views}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
