<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/16
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>请登录</title>
  </head>
  <body>
  <c:if test="${sessionScope.register != null}">
    注册成功！请登录
    <%
      session.invalidate();
    %>
  </c:if>
  <c:if test="${sessionScope.loginFail != null}">
    密码错误请重新登陆
    <%
      session.invalidate();
    %>
  </c:if>
  <form method="post" action="<c:url value="login"/>">
    账号:<input type="text" name="account">
  <br />
    密码:<input type="password" name="pwd">
    <br />
    <input type="submit" value="登陆">
  </form>
  <form action="<c:url value="resgister.jsp"/> " method="post">
    <input type="submit" value="注册">
  </form>
  </body>
</html>
