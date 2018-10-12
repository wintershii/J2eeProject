<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/12
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body{text-align: center}
    </style>
    <title>功能</title>
</head>
<body>
<div>
    <h3>选择功能</h3>
    <table align="center" border="2">
<form action="/show/person.jsp" method="post">
    <input type="submit" value="查看个人信息" align="center">
</form>
    <br />
<form action="/list" method="post">
    <input type="submit" value="查看所有信息" align="center">
</form>
    </table>
</div>
</body>
</html>
