<%@ page import="com.winter.poju.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/9/29
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>

</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">个人信息</a></li>
        <li><a href="#">查看个人信息</a></li>
    </ul>
</div>

<div class="rightinfo">

    <table class="tablelist">
        <thead>
        <tr>
            <th>用户ID<i class="sort"><img src="../images/px.gif" /></i></th>
            <th>用户名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>出生日期</th>
        </tr>
        </thead>
        <tbody>

        <%
            List<User> list = (ArrayList<User>)request.getAttribute("list");
            for (User u: list){
        %>
        <tr>
            <td><%=u.getUid()%></td>
            <td><%=u.getUname()%></td>
            <%
                if (u.getSex().equals("1")){
            %>
            <td>男</td>
            <%
                } else {
            %>
            <td>女</td>
            <%
                }
            %>
            <td><%=u.getAge()%></td>
            <td><%=u.getBirth()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>


</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>

