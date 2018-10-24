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
    <link type="text/css" href="editor.md-master/lib/codemirror/codemirror.min.css">
    <script type="text/javascript" src="editor.md-master/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="editor.md-master/editormd.min.js"></script>
    <link rel="stylesheet" href="editor.md-master/css/editormd.css">
    <style>
        .articleShow {position: absolute; left: 300px; right: 300px;
            width: 800px;border: 1px outset #0a001f;}
    </style>
</head>
<div class="articleShow">
<body>
<div style="text-align: center">
<h3>${article.title}</h3>
作者:${article.author}
<br />
<br />
发布日期:<%=new SimpleDateFormat("yyyy-MM-dd").format(((Article)request.getAttribute("article")).getaDate())%>
浏览量:${article.views}
</div>
<br />
<div class="editormd-html-textarea" style="align-content: left;padding: 10px;">
    ${article.essay}
</div>

</body>
</div>
</html>
