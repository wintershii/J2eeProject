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
    <title>师东璇的博客主页</title>
    <style type="text/css">
      .login {position: absolute;border: 1px;text-align: center; left: 550px; bottom: 300px;line-height: 50px}
      #login {height: 200px;width: 400px;border: 1px outset #0a001f; }
      .header {position: absolute;left: 730px; top: 180px}
    </style>
  </head>
  <body>
  <c:if test="${sessionScope.loginFail != null}">
    密码错误请重新登陆
  </c:if>
  <c:if test="${sessionScope.register != null}">
    注册成功！请登录
  </c:if>
  <%
    session.invalidate();
  %>
  <div class="header">
    <h3>登陆</h3>
  </div>

<div class="login" id="login">
  <form method="post" action="<c:url value="login"/>">
    <input type="hidden" value="0" name="id">
    账号:<input type="text" name="account">
  <br />
    密码:<input type="password" name="pwd">
    <br />
    <input type="submit" value="登陆">
  </form>
  <form action="<c:url value="resgister.jsp"/> " method="post">
    <input type="submit" value="注册">
  </form>
</div>
  </body>
</html>
