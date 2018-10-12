<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/12
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body{text-align: center}
    </style>
    <title>修改信息</title>
</head>
<body>
<div>
    <h3>修改信息</h3>
<form action="/update2" method="post">
    <input type="hidden" value="${updateStu.id}" name="id">
    <table border="2" align="center">
        <tr>
            <td>学号:</td>
            <td>${updateStu.uname}</td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td><input type="text" name="name" required="required" value="${updateStu.name}"></td>
        </tr>
        <tr>
            <td>班级:</td>
            <td><input type="text" name="class" required="required" value="${updateStu.classnum}"></td>
        </tr>
        <tr>
            <td>入学日期:</td>
            <td><input type="date" name="date" required="required"value="${updateStu.entryDate}"></td>
        </tr>
    </table>
    <br />
    <input type="submit" value="提交">
</form>
</div>
</body>
</html>
