<%@ page import="com.winter.poju.User" %><%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/9/27
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="../js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            //顶部导航切换
            $(".nav li a").click(function(){
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })

            //退出功能
            $("#out").click(function () {
                var flag = window.confirm("你真的要退出吗?");
                if (flag){
                    window.top.location.href="../user?oper=out";
                }
            })

        })

    </script>

</head>

<body style="background:url(../images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="" target="_parent"><img src="../images/logo.png" title="系统首页" /></a>
</div>

<div class="topright">
    <ul>
        <li><span><img src="../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
        <li><a href="javascript:void(0)" id="out" >退出</a></li>
    </ul>

    <div class="user">
        <span>
            <%=
                ((User)session.getAttribute("user")).getUname()
            %>
        </span>
    </div>

</div>

</body>
</html>