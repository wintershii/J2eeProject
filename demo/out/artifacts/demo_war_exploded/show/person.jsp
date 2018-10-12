<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/12
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息界面</title>
</head>
<body>
<table border="2">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>班级</td>
        <td>入学时间</td>
        <td>操作</td>
    </tr>
    <tr>
        <td>${sessionScope.stu.uname}</td>
        <td>${sessionScope.stu.name}</td>
        <td>${sessionScope.stu.classnum}</td>
        <td>${sessionScope.stu.entryDate}</td>
        <td><a href="">修改</a> | <a href="">删除</a></td>
    </tr>
</table>
</body>
</html>
