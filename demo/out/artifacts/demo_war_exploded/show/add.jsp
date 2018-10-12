<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/12
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body{text-align: center}
    </style>
    <title>添加新成员</title>
</head>
<body>
<div>
    <h3>添加学生信息</h3>
<form action="/add" method="post">
<table border="2" align="center">
    <tr>
        <td>学号:</td>
        <td><input type="text" name="uname" required="required"></td>
    </tr>
    <tr>
        <td>密码:</td>
        <td><input type="password" name="pwd" required="required"></td>
    </tr>
    <tr>
        <td>姓名:</td>
        <td><input type="text" name="name" required="required"></td>
    </tr>
    <tr>
        <td>班级:</td>
        <td><input type="text" name="class" required="required"></td>
    </tr>
    <tr>
        <td>入学日期:</td>
        <td><input type="date" name="date" required="required"></td>
    </tr>
</table>
    <input type="submit" value="提交">
</form>
</div>
</body>
</html>
