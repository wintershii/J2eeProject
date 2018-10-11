<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/11
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>登陆账号-3G在线选课系统</title>
  <meta name="description" content="">
  <meta name="keywords" content="">
  <!-- 重置样式 -->
  <link href="css/reset.css" rel="stylesheet">
  <!-- 引入bootstrap CSS -->
  <link href="css/bootstrap.css" rel="stylesheet">
  <!-- 核心CSS文件 -->
  <link href="css/login.css" rel="stylesheet">
</head>
<body>
<!-- 头部导航 -->
<div class="header">
  <div class=".layout-logo">
    <img src="/public/static/front/images/logo.png" alt="" class="layout-logo">
  </div>
  <div class="layout-user">
    <p>3G在线选课系统</p>
  </div>
</div>

<!-- 核心内容 -->
<div class="wrap clearfix">

  <!-- 左侧表单信息 -->
  <div class="left">

    <!-- 学生登录表单 -->
    <form class="form active" id="student" method=post action="/index/login/student.html">
      <h2>学生登录</h2>
      <div class="input">
        <input  type="text"  maxlength="8" placeholder="请输入您的学号" name="student" required="true" placeholder="请输入您的学号" onkeyup="value=value.replace(/[^\d\._]/g,'')"  />
      </div>
      <div class="input">
        <input type="password" placeholder="请输入您的密码" maxlength="16" minlength="6" name="password" required="true" />
      </div>
      <div class="input">
        <input type="text" name="captcha" class="pass-text-input " placeholder="请输入验证码">
        <br/><br/>
        <!-- <img src="/captcha.html" alt="captcha" /> -->
        <img src="/captcha.html"  onclick="this.src='/captcha.html'">
        <!-- <img id="img" src="<img src="/captcha.html" alt="captcha" />" onclick='this.src=this.src+"?"+Math.random()'  style="width: 200px;height:45px;" /> -->
      </div>
      <div class="input">
        <Button class="mainBtn submitBtn btn btn-success">立即登录</Button>
        <a class="mainBtn forgotBtn btn btn-warning" href="/index/repassword/repassword/type/1.html">忘记密码</a>
      </div>
    </form>


    <!-- 管理员登录表单 -->
    <form class="form" id="admin" method=post action="/index/login/admin.html">
      <h2>管理员登录</h2>
      <div class="input">
        <input placeholder="请输入管理员账号" class="" maxlength="15"  name="admin"  required="true"  />
      </div>
      <div class="input">
        <input type="password" placeholder="请输入您的密码" minlength="6" maxlength="16"  required="true" name="password" />
      </div>
      <div class="input">
        <input type="text" name="captcha" class="pass-text-input " placeholder="请输入验证码">
        <br/><br/>
        <div><img src="/captcha.html" alt="captcha" onclick="this.src='/captcha.html'"/></div>
        <!-- <img id="img" src="front/Verify" onclick='this.src=this.src+"?"+Math.random()'  style="width: 200px;height:45px;" /> -->
      </div>
      <div class="input">
        <Button class="mainBtn submitBtn btn btn-success">立即登录</Button>
      </div>
    </form>

    <!-- 切换身份按钮 -->
    <button class="ctrlBtn btn-sm btn btn-info btn-danger">我是学生</button>
    <button class="ctrlBtn btn-sm btn btn-info">我是管理</button>
  </div>

  <!-- 右侧身份图片 -->
  <div class="right">
    <img id="rightImg" src="/public/static/front/images/student1.png" alt="学生形象图" title="我是学生">
  </div>
</div>

<!-- Footer区域 -->
<div class="el-footer">
  <div class="links">
    <a target="_blank" href="http://www.xiyou.edu.cn/">西安邮电大学</a> |
    <a target="_blank" href="http://cs.xupt.edu.cn:81/xiyoucs/index.asp">计算机学院</a> |

    <a target="_blank" href="https://www.xiyoumobile.com">移动应用开发实验室</a>
  </div>
  <p class="copyright"> Copyright © 2018 3G All Rights Reserved </p>
</div>


<script>
    function Tab(){}
    Tab.prototype.init = function(btn,box){
        this.aBox = document.getElementsByClassName(box);
        this.aBtn = document.getElementsByClassName(btn);
        this.aBtnProto = this.aBtn[1].className;
        this.aBtnName = this.aBtn[1].text;

        var This = this;

        var oIndex=this.aBtn.length;
        for(var i=0;i<oIndex;i++){
            this.aBtn[i].index = i;
            this.aBtn[i].onclick = function(){
                This.change(this,This.aBtnProto,box);
            };
        }
    };
    Tab.prototype.change = function(obj,aBtn,box){
        for(var i=0;i<this.aBtn.length;i++){
            this.aBtn[i].className =aBtn;
            this.aBox[i].style.display = 'none';
        }
        obj.className = aBtn + ' btn-danger';
        this.aBox[obj.index].style.display = 'block';
        this.aBtnName = this.aBox[obj.index].id;

        var oImg=document.getElementById('rightImg');
        oImg.src="/public/static/front/images/"+ this.aBtnName +"1.png";
    };
    var oForm = new Tab();
    oForm.init('ctrlBtn','form');
</script>
</body>
</html>