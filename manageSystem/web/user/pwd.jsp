<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/9/29
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../js/jquery.js"></script>>
<!-- 引入jQuery文件-->
    <script type="text/javascript">
        $(function () {
            //校验密码修改
            $("#fm").submit(function () {
                //校验新密码
                if ( $("#newPwd").val() == "" || $("#newPwd").val() == null){
                    alert("新密码不能为空！");
                    return false;
                } else if ($("#confirmPwd").val() == "" || $("#confirmPwd").val() == null){
                    alert("确认密码不能为空!");
                    return false;
                } else if ($("#newPwd").val() != $("#confirmPwd").val()) {
                    alert("两次密码不一致!");
                    return false;
                } else {
                    return true;
                }
            })
        })
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">个人信息</a></li>
        <li><a href="#">修改密码</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>修改密码</span></div>
<form action="/user" method="post" id="fm">
    <input type="hidden" name="oper" value="pwd">
    <ul class="forminfo">
        <li><label>新密码</label><input name="newPwd" id="newPwd" type="text" class="dfinput" /></li>
        <li><label>确认密码</label><input name="" id="confirmPwd" type="text" class="dfinput" /></li>
        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
</form>

</div>


</body>

</html>
