<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/17
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册新用户</title>
    <style>
        .registerBox {position: absolute;border: 1px outset #0a001f;text-align: center; left: 550px; bottom: 200px;
            line-height: 50px;height: 500px;width: 400px;}
    </style>
</head>
<body>
<div class="registerBox">
<form method="post" action="<c:url value="register"/>">
    <h2>新用户注册</h2>
    账号:<input type="text" name="account" required="required">
    <br />
    密码:<input type="password" name="pwd" required="required">
    <br />
    昵称:<input type="text" name="name" required="required">
    <br />
    性别:男<input type="radio" name="sex" value="1" checked="checked">
        女<input type="radio" name="sex" value="0">

    <br />
    生日:<input type="date" name="birth" required="required">
    <br />
    个性签名:<input type="text" name="signature">
    <br />
    <input type="submit" value="注册">
</form>
</div>
</body>
</html>
