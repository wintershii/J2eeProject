<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/9/29
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 声明js代码域 -->
<script type="text/javascript">
    function getDate() {
        //获取元素对象
        var showdiv = document.getElementById("showdiv");
        //修改元素内容
        showdiv.innerHTML = "你好ajax";
    }
</script>

<style type="text/css">
    #showdiv{
        border:solid 1px;
        width: 200px;
        height: 100px;
    }
</style>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>欢迎登陆</h3>
    <hr>
    <input type="button" value="测试" onclick="getDate()">
    <div id="showdiv"></div>
</body>
</html>
