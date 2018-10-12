<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/12
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登陆</title>
  </head>
  <body>
  <form action="/login" method="post">
      账号:<input type="text" name="uname" >
      密码:<input type="password" name="pwd" >
      <input type="submit" value="登陆">
  </form>
  <c:if test="${sessionScope.check != null}">
      <br />
      <div style="color: red">
          账号密码有误！
          <%
              session.invalidate();
          %>
      </div>
  </c:if>
  </body>
</html>
