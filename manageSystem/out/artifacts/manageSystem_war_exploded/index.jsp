<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/9/27
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>欢迎登录学生管理系统</title>
  <link href="css/style.css" rel="stylesheet" type="text/css" />
  <script language="JavaScript" src="js/jquery.js"></script>
  <script src="js/cloud.js" type="text/javascript"></script>

  <script language="javascript">
      $(function(){
          $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
          $(window).resize(function(){
              $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
          })
      });
  </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



<div id="mainBody">
  <div id="cloud1" class="cloud"></div>
  <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
  <span>欢迎登录后台管理界面平台</span>
  <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
  </ul>
</div>

<div class="loginbody">

  <span class="systemlogo"></span>

  <div class="loginbox loginbox1">

      <form action="user" method="post">
          <input type="hidden" name="oper" value="login" />
    <ul>
      <li><input name="uname" type="text" placeholder="用户名" class="loginuser" /></li>
      <li><input name="pwd" type="password" placeholder="密码" class="loginpwd" /></li>
      <li class="yzm">
        <span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite>
      </li>
      <li><input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  />
          <label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    </ul>
      </form>


  </div>

</div>


<div class="loginbm">版权没有 3GServer 2018 <a href="http://www.xiyoumobile.com">xiyoumobile.com</a> XiyouMobile </div>


</body>

</html>

