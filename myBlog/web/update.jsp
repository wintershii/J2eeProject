<%@ page import="winter.pojo.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/18
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
    <style>
        .updateBody {position: absolute;border: 1px outset #0a001f;text-align: center; left: 550px; bottom: 200px;
            line-height: 50px;height: 500px;width: 400px;}
    </style>
</head>
<body>
<div class="updateBody">
<form action="<c:url value="update1"/>" method="post">
    <input type="hidden" value="${sessionScope.user.id}" name="id">
    账号:${sessionScope.user.account}
    <br />
    昵称:<input type="text" name="name" required="required" value="${sessionScope.user.name}">
    <br />
    性别:<%
    if (((User)session.getAttribute("user")).getSex() == 1){
        %>
    男<input type="radio" name="sex" value="1" checked="checked">
    女<input type="radio" name="sex" value="0">
    <%
    } else {
    %>
    男<input type="radio" name="sex" value="1">
    女<input type="radio" name="sex" value="0" checked="checked">
    <%
    }
    %>
    <br />
    生日:<input type="date" name="birth" required="required"
              value="<%=new SimpleDateFormat("yyyy-MM-dd").format(((User)session.getAttribute("user")).getBirth())%>">
    <br />
    个性签名:<input type="text" name="signature" value="${sessionScope.user.signature}">
    <br />
    <input type="submit" value="修改信息">
</form>
</div>
</body>
</html>
