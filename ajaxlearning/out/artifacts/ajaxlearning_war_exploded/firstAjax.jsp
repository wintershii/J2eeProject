<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/1
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一个ajax</title>
    <script type="text/javascript">
        function getData() {
            //创建ajax引擎对象
                var ajax;
                if (window.XMLHttpRequest){//火狐
                    ajax = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    ajax = new ActiveXObject("Msxml2.XMLHTTP");
                }
            //复写onreadystatement函数
            ajax.onreadystatechange = function(){
                //判断ajax状态码
                if (ajax.readyState == 4) {
                    if (ajax.status == 200) {
                        //获取响应内容
                        //获取元素对象
                        var result = ajax.responseText;
                        alert(result);
                        var showdiv = document.getElementById("showdiv");
                        showdiv.innerHTML = result;
                    } else if (ajax.status == 404){
                        var showdiv = document.getElementById("showdiv");
                        showdiv.innerHTML = "请求资源不存在";
                    } else if (ajax.status == 500){
                        var showdiv = document.getElementById("showdiv");
                        showdiv.innerHTML = "服务器繁忙";
                    }
                }
            }
            //发送请求
            ajax.open("get","ajax");
            ajax.send(null);



        }
    </script>
    <style type="text/css">
        #showdiv{
            border: solid 1px;
            width: 200px;
            height: 100px;
        }
    </style>
</head>
<body>
    <h3>欢迎</h3>
    <input type="button" value="测试" onclick="getData()">
    <div id="showdiv"></div>
</body>
</html>
