<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/17
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册新用户</title>
    <style>
        .registerBox {position: absolute;border: 1px outset #0a001f;text-align: center; left: 550px; bottom: 200px;
            line-height: 50px;height: 500px;width: 400px;
            float: top;background-color: rgba(240, 255, 255, 0.3);
            border-radius: 10px;
        }
        .btns { width:143px; height:40px;
            background:url("http://www.divcss5.com/uploads/allimg/1309/1_130916141906_1.jpg") no-repeat left top;
            color:#FFF; }
    </style>
</head>
<body background="http://pic32.photophoto.cn/20140723/0008020945920117_b.jpg">
<div class="registerBox">
<form method="post" action="<c:url value="/user/register"/>">
    <h2>新用户注册</h2>
    账号:<input type="text" name="account" required="required">
    <br />
    密码:<input type="password" name="pwd" required="required">
    <br />
    昵称:<input type="text" name="name" required="required">
    <br />
    性别:男<input type="radio" name="sex" value="1" checked="checked">
        女<input type="radio" name="sex" value="0">

    <br />
    生日:<input type="date" name="birth" required="required">
    <br />
    个性签名:<input type="text" name="signature">
    <br />
    <input type="submit" value="注册" class="btns" onmouseover="this.style.backgroundPosition='left -40px'"
           onmouseout="this.style.backgroundPosition='left top'">
</form>
</div>
</body>
</html>
