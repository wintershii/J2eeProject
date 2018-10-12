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
      <style>
          body{text-align: center}
      </style>
    <title>登陆</title>
  </head>
  <body>
  <div>
      <h3>用户登陆</h3>
  <form action="/login" method="post" >
      账号:<input type="text" name="uname" >
      <br/>
      密码:<input type="password" name="pwd" >
      <br/>
      <br />
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
  </div>
  </body>
</html>
