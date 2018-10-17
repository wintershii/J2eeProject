<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/14
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>选择</title>
  </head>
  <body>
  <form action="<c:url value="list"></c:url>" method="post">
    <input type="submit" value="查看列表">
  </form>
  <c:if test="${isNull != null}">
    商品列表为空!
    <%
      response.sendRedirect("index.jsp");
    %>
  </c:if>

  </body>
</html>
