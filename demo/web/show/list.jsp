<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>学生信息表</title>
</head>
<body>
<div>
    <h3>学生信息列表</h3>
<table border="2" align="center">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>班级</td>
        <td>入学时间</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${student}" var="stu">
        <tr>
            <td>${stu.uname}</td>
            <td>${stu.name}</td>
            <td>${stu.classnum}</td>
            <td>${stu.entryDate}</td>
            <td><a href="/delete?id=${stu.id}">删除</a> | <a href="/update?id=${stu.id}">修改</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="show/add.jsp">添加</a></td>
    </tr>
</table>
</div>
</body>
</html>
