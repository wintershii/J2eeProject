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
    <title>EditorMD</title>
    <link type="text/css" href="/editor.md-master/lib/codemirror/codemirror.min.css">
    <script type="text/javascript" src="/editor.md-master/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="/editor.md-master/editormd.min.js"></script>
    <link rel="stylesheet" href="/editor.md-master/css/editormd.css">
    <style>
        .sub{width:140px;height:36px;line-height:18px;font-size:18px;
            position: absolute;right: 200px; top:25px;
            background:url("http://www.divcss5.com/uploads/allimg/1309/1_130916141709_1.jpg") no-repeat left top;
            color:#FFF;padding-bottom:4px}
    </style>
</head>

<body background="http://pic32.photophoto.cn/20140723/0008020945920117_b.jpg">
<form method="post" action="<c:url value="/article/submit"/>">
    <h2 style="position: absolute; left: 80px">标题:<input type="text" name="title" style="width: 400px;height: 30px;" required="required"></h2>
    <input type="hidden" name="author" value="${sessionScope.user.name}">
    <input type="hidden" name="aid" value="${sessionScope.user.id}">
<div class="editormd" id="test-editormd" style="top: 70px">
    <textarea class="editormd-markdown-textarea" name="markdown" required="required"></textarea>
    <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
    <textarea class="editormd-html-textarea" name="essay"></textarea>
</div>
    <div>
    <input type="submit" value="发布文章" class="sub" onmouseover="this.style.backgroundPosition='left -36px'"
           onmouseout="this.style.backgroundPosition='left top'">
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
            path    : "/editor.md-master/lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea : true,
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "/article/uploadFile",
        });

    });


    //editor.md期望得到一个json格式的上传后的返回值，格式是这样的：
    /*
    {
        success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
        message : "提示的信息，上传成功或上传失败及错误信息等。",
        url     : "图片地址"        // 上传成功时才返回
    }
    */

</script>
</body>
</html>

