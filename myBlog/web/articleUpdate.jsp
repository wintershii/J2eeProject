<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/18
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>编辑文章</title>
    <link type="text/css" href="editor.md-master/lib/codemirror/codemirror.min.css">
    <script type="text/javascript" src="editor.md-master/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="editor.md-master/editormd.min.js"></script>
    <link rel="stylesheet" href="editor.md-master/css/editormd.css">
    <style>
        .submit {position: absolute;right: 300px; top:30px;}
    </style>
</head>

<body>
<form method="post" action="<c:url value="articleUpdate1"/>">
    <h2 style="position: absolute; left: 80px">标题:<input type="text" name="title" style="width: 400px;height: 30px;" required="required" value="${title}"></h2>
    <input type="hidden" name="id" value="${id}">
    <div class="editormd" id="test-editormd" style="top: 70px">
        <textarea class="editormd-markdown-textarea" name="markdown" required="required">${preMarkdown}</textarea>
        <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
        <textarea class="editormd-html-textarea" name="essay"></textarea>
    </div>
    <div class="submit">
        <input type="submit" value="发布文章">
    </div>
</form>
<br />
<script type="text/javascript">
    $(function() {
        editormd("test-editormd", {
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            //你的lib目录的路径，我这边用JSP做测试的
            path    : "editor.md-master/lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea : true
        });
    });
</script>
</body>
</html>