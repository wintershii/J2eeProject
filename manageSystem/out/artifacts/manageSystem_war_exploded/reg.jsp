<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/9/29
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>新用户注册</title>
</head>
<h3 align="center">新用户注册</h3>
<body>

<form action="/user" method="post">
    <input type="hidden" name="oper" value="reg">
    <table cellpadding="5" align="center">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="uname"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                男<input type="radio" name="sex" value="1">
                女<input type="radio" name="sex" value="0">
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input  type="text" name="age"></td>
        </tr>
        <tr>
            <td>出生日期</td>
            <td><input type="date" name="birth"></td>
        </tr>
        <tr>
            <td align="center"></td>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>

</body>
</html>
