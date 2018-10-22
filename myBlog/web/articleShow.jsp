<%@ page import="winter.pojo.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="winter.pojo.Article" %><%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/19
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${article.title}</title>
    <style>
        .articleShow {position: absolute;text-align: center; left: 300px; right: 300px;
            width: 800px;border: 1px outset #0a001f;}
    </style>
</head>
<div class="articleShow">
<body>
<h3>${article.title}</h3>
作者:${article.author}
<br />
<br />
发布日期:<%=new SimpleDateFormat("yyyy-MM-dd").format(((Article)request.getAttribute("article")).getaDate())%>
浏览量:${article.views}
<br />
${article.essay}
</body>
</div>
</html>
