<%@ page import="java.util.Date" %>
<%@ page import="winter.pojo.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/18
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
<table border="1">
    <tr>
        个人信息
    </tr>
    <tr>
        <td>账户:</td>
        <td>${sessionScope.user.account}</td>
    </tr>
    <tr>
        <td>昵称:</td>
        <td>${sessionScope.user.name}</td>
    </tr>
    <tr>
        <td>性别:</td>
        <td><c:if var="sexId" test="${sessionScope.user.sex == 1}"/>
            ${sexId?"男":"女"}
        </td>
    </tr>
    <tr>
        <td>生日:</td>
        <td><%
            Date birth = ((User)session.getAttribute("user")).getBirth();
            out.print(new SimpleDateFormat("yyyy-MM-dd").format(birth));
        %></td>
    </tr>
    <tr>
        <td>个性签名:</td>
        <td>${sessionScope.user.signature}</td>
    </tr>
</table>
<a href="<c:url value="update.jsp"/>">修改个人信息</a>
<a href="<c:url value="editor.jsp"/> ">写文章</a>
<a href="<c:url value="show?id=0"/>">博客大厅</a>
<a href="<c:url value="show?id=${sessionScope.user.id}"/>">我的博客</a>
</body>
</html>
