<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/14
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
</head>
<body>
<form method="post" action="/update1">
    <input type="hidden" name="id" value="${good.id}">
    名称:<input type="text" name="name" value="${good.name}"> <br />
    类型:<input type="text" name="gType" value="${good.gType}"> <br />
    产地:<input type="text" name="location" value="${good.location}"> <br />
    上架时间:<input type="date" name="gDate" value="${good.gDate}"> <br />
    商品库存:<input type="text" name="gRest" value="${good.gRest}"> <br />
    <input type="submit" value="修改">
</form>
</body>
</html>
