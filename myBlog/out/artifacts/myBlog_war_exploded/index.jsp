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
      #login {height: 200px;width: 400px;border: 1px outset #0a001f;float: top;background-color: rgba(240, 255, 255, 0.3);
        border-radius: 10px;
        text-align: center;}
      .header {position: absolute;left: 730px; top: 180px;}
      .btns { width:143px; height:40px; background:url("http://www.divcss5.com/uploads/allimg/1309/1_130916141906_1.jpg") no-repeat left top; color:#FFF; }
      li{float:left;list-style: none;}
    </style>
  </head>
  <body background="http://pic32.photophoto.cn/20140723/0008020945920117_b.jpg">
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
    账号:<input type="text" name="account" required="required">
  <br />
    密码:<input type="password" name="pwd" required="required">
    <br />
    <div>
        <input type="submit" class="btns" onmouseover="this.style.backgroundPosition='left -40px'"
               onmouseout="this.style.backgroundPosition='left top'" value="登陆" />
      </div>
  </form>

    <div style="position: absolute;left: 100px;bottom: 20px">
      <ul>
        <li><a href="<c:url value="resgister.jsp"/>">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
        <li><a href="<c:url value=""/>">忘记密码?</a></li>
      </ul>
    </div>

</div>
  </body>
</html>
