<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/14
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增商品</title>
</head>
<body>
<form method="post" action="/add">
    名称:<input type="text" name="name"> <br />
    类型:<input type="text" name="gType"> <br />
    产地:<input type="text" name="location"> <br />
    上架时间:<input type="date" name="gDate"> <br />
    商品库存:<input type="text" name="gRest"> <br />
    <input type="submit" value="提交">
</form>
</body>
</html>
