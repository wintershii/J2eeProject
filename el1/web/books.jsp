<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/8
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书展示</title>
    <style>
        table,tr,td{
            border: 1px solid brown;
        }
    </style>
</head>
<body>
Books in Simple Table
<table>
    <tr>
        <td>书名</td>
        <td>作者</td>
        <td>出版时间</td>
    </tr>
    <c:forEach items="${requestScope.books}" var="book">
        <tr>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.date}</td>
        </tr>
    </c:forEach>
</table>

<br />


Big Cities in different country
<table>
    <tr>
        <td>国家</td>
        <td>城市</td>
    </tr>
    <c:forEach items="${requestScope.bitCities}" var="city">
        <tr>
            <td>${city.key}</td>
            <td>
                <c:forEach items="${city.value}" var="temp">
                    ${temp}
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
