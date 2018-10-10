<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/8
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL学习</title>
</head>
<body>
    <c:set var="pwd" value="990708"/>
<c:if test="${pwd == '990708'}">
    You Log In Successfully
</c:if>

    <br />

<c:if test="${cookie.cookie.value != 'shi'}" var="loginId"/>
${(loginId)? "You Log In Successfully" : "Login failed"}

<form action="jstl.jsp" method="post">
    信息:<input type="text" name="data" value="">
    <input type="submit" value="提交">
</form>

<c:choose>
        <c:when test="${param.data == '1'}">
            你输入了1
        </c:when>
        <c:when test="${param.data == '2'}">
            你输入了2
        </c:when>
        <c:otherwise>
            哈啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
        </c:otherwise>
    </c:choose>
</body>
</html>
