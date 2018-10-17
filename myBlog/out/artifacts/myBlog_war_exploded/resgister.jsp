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
</head>
<body>
<form method="post" action="<c:url value="register"/>">
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
</body>
</html>
