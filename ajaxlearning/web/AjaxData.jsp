<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/10/1
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎访问英雄商店</title>
    <!--
        需求：
            1.在当前页面内显示查询结果，使用ajax
            2.创建ajax函数
            3.调用ajax函数发送请求到UserServlet
            4.调用业务层获取对应的数据
     -->

    <!-- 声明script代码域-->

    <script type="text/javascript">
        //获取数据
            function getData() {
                //校验
                //创建ajax引擎对象
                var ajax = new XMLHttpRequest();
                //复写onreadystatechange
                ajax.onreadystatechange = function () {
                    //判断ajax状态码
                    if (ajax.readyState == 4){
                        if (ajax.status ==200){

                        }
                    }
                }
                //发送请求
                ajax.open("get","user?name="+name);
                ajax.send(null);
            }
    </script>
</head>
<body>
    <h3>欢迎访问英雄商店</h3>
    <hr>
    英雄名称:<input type="text" name="uname" value="" id="uname">
                <input type="button" value="搜索">
    <hr>

    <table border="1px">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
            <td>位置</td>
            <td>描述</td>
        </tr>
    </table>
</body>
</html>
