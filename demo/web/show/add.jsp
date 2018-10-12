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
    <title>添加新成员</title>
</head>
<body>
<form action="/add" method="post">
<table border="2">
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

    <<input type="submit" value="提交">
</table>
</form>
</body>
</html>
