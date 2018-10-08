<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/8
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
    accept-language:${header['accept-language']}
<br />
    session id:${pageContext.session.id}
<br />
    employee:${requestScope.employee.name},${employee.adress.city}
<br />
    capital:${capitals["Canada"]}


    <%--out标签--%>
    <br />
session:    <c:out value="${sessionScope.what}"/>

    <br />
cookie:    <c:out value="${cookie.cookie.value}"/>

<%--set标签--%>
<br />

<c:set var="uname" value="wintershii"/>
<c:set target="${employee}" property="name" value="张硕"/>
    <br />
    uname:
    <c:out value="${uname}"/>
    <br />
    更改姓名：
<c:out value="${employee.name}"/>


<c:remove var="uname"/>
    <br />
    删除后:
    <c:out value="${uname}"/>
</body>
</html>
