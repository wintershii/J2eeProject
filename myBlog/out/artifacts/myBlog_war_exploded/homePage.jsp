<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page import="winter.pojo.User" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/22
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.name}的主页</title>
    <style>
        .top {position: absolute;border: 1px outset #0a001f;width: 1500px;height: 80px;padding: 10px;
        }
        .homeInfo {position: absolute;top: 120px;border: 1px outset #0a001f;
            width: 250px;height: 220px;text-align: center;padding: 10px;}
        .showList {position: absolute;left: 350px; right: 150px; top: 120px;border: 1px outset #0a001f;
            padding: 10px; line-height: 30px}
    </style>
</head>
<body>
<div class="top">
    <h2>${user.name}的博客</h2>

</div>

<div class="homeInfo">
<table>
    <tr>
        <td>昵称</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>性别:</td>
        <td><c:if var="sexId" test="${user.sex == 1}"/>
            ${sexId?"男":"女"}
        </td>
    </tr>
        <td>生日:</td>
        <td><%
            Date birth = ((User)request.getAttribute("user")).getBirth();
            out.print(new SimpleDateFormat("yyyy-MM-dd").format(birth));
        %></td>
    </tr>
    <tr>
        <td>个性签名</td>
        <td>${user.signature}</td>
    </tr>
</table>
</div>

<div class="showList">
    <table>
        <tr>
            <td>&nbsp;&nbsp;</td>
            <td>&nbsp;&nbsp;</td>
            <td style="text-align: center;font-size: 20px">博客大厅</td>
        </tr>
        <tr>
            <td>标题</td>
            <td>作者</td>
            <td style="text-align: center">概览</td>
            <td>日期</td>
            <td>浏览量</td>
        </tr>
        <c:forEach items="${articleList}" var="a">
            <tr>
                <td><a href="<c:url value="articlePage?id=${a.id}"/>">${a.title}</a></td>
                <td><a href="<c:url value="homePage?aid=${a.aid}"/>">${a.author}</a> </td>
                <td>${a.essay}</td>
                <td>${a.aDate}</td>
                <td>${a.views}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
