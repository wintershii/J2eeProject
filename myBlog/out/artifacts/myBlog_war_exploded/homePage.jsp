<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<%@ page import="winter.pojo.User" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/22
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.name}的主页</title>
    <style>
        .top {position: absolute;border: 1px outset #0a001f;width: 1500px;height: 80px;padding: 10px;
            float: top;background-color: rgba(240, 255, 255, 0.3);
        }
        .homeInfo {position: absolute;top: 120px;border: 1px outset #0a001f;
            width: 250px;height: 220px;text-align: center;padding: 10px;
            background-color: rgba(240, 255, 255, 0.3);float: top;
        }
        .showList {position: absolute;left: 350px; right: 100px; top: 120px;border: 1px outset #0a001f;
            padding: 10px;
            background-color: rgba(240, 255, 255, 0.3);float: top;;
        }
        li{float:left;list-style: none;}
    </style>
</head>
<body background="http://pic32.photophoto.cn/20140723/0008020945920117_b.jpg">
<div class="top">
    <h2>${user.name}的博客</h2>

</div>

<div class="homeInfo">
<table>
    <tr>
        <td>昵称</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>性别:</td>
        <td><c:if var="sexId" test="${user.sex == 1}"/>
            ${sexId?"男":"女"}
        </td>
    </tr>
        <td>生日:</td>
        <td><%
            Date birth = ((User)request.getAttribute("user")).getBirth();
            out.print(new SimpleDateFormat("yyyy-MM-dd").format(birth));
        %></td>
    </tr>
    <tr>
        <td>个性签名:</td>
        <td>${user.signature}</td>
    </tr>
</table>
</div>

<div class="showList">

    <c:forEach items="${articleList}" var="a">
        <div>
            <h2><a href="<c:url value="/article/showSingle?id=${a.id}"/>">${a.title}</a></h2>
            <h4>${a.essay}</h4>
            <ul>
                <li>作者:<a href="<c:url value="/user/otherHome?aid=${a.aid}"/>">${a.author}</a>&nbsp;&nbsp;&nbsp;</li>

                <li>发布日期:<fmt:formatDate value="${a.aDate}" pattern="yyyy-MM-dd"/>&nbsp;&nbsp;&nbsp;</li>

                <li>浏览量:${a.views}</li>
            </ul>
            <br />
        </div>
    </c:forEach>
</div>
</div>
</body>
</html>
