<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="editor.md-master/css/editormd.css">
    <script language="JavaScript" src="editor.md-master/jquery-3.1.1.min.js"></script>
    <style>
        .articleShow {position: absolute; left: 300px;
            width: 800px;}
        div,code {}
    </style>
    <script type="text/javascript">
        $(function () {
            $("#artidelete").click(function () {
                var flag = window.confirm("确定要删除该文章吗?");
                if (flag){
                    window.top.location.href="<c:url value="articleDelete?id=${article.id}"/>";
                }
            })
        })
    </script>

</head>
<div class="articleShow">
<body background="http://pic32.photophoto.cn/20140723/0008020945920117_b.jpg">
<div style="text-align: center;background: white;border-radius: 10px;width: 818px">
<h2>${article.title}</h2>
作者:<a href="<c:url value="homePage?aid=${article.aid}"/>">${article.author}</a>
<br />
<br />
发布日期:<%=new SimpleDateFormat("yyyy-MM-dd").format(((Article)request.getAttribute("article")).getaDate())%>
浏览量:${article.views}
    <c:if test="${sessionScope.user.id == article.aid}">
    <a href="<c:url value="articleUpdate?id=${article.id}"/>">编辑</a>
    <a href="javascript:void(0)" id="artidelete">删除</a>
    </c:if>
</div>
<br />
<div class="editormd-html-textarea" id="content" style="align-content: left;padding: 10px;">${article.essay}</div>
<script src="editor.md-master/jquery-3.1.1.min.js"></script>
<script src="editor.md-master/lib/marked.min.js"></script>
<script src="editor.md-master/lib/prettify.min.js"></script>
<script src="editor.md-master/editormd.min.js"></script>
<script type="text/javascript">
    editormd.markdownToHTML("content");
</script>
</body>
</div>
<div style="position: absolute; top: 10px;right: 20px;">
    <a href="<c:url value="show?id=0"/>">首页</a>
</div>
</html>