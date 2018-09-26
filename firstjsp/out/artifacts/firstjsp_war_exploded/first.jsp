<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/9/25
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page errorPage="error.jsp" %>
<html>
<head>
    <title>JSP基本语法学习</title>
    <meta charset="utf-8"/>
</head>
 <body>
    <h3>hhhhh</h3>
    <hr />
    <%
        String str = "jsp中使用逻辑校验很难受";
        int a = 2;
        if (a > 3){
    %>
    <b>jsp学习很简单</b>
    <%
        } else {
    %>
    <i><%=str%></i>
    <%
            test();
        }
    %>

    <%!
        public void test(){
            System.out.println("全局代码块测试");
        }
    %>

    <%--<%@include file="index.jsp" %>--%>
    <%--<jsp:include page="index.jsp"></jsp:include>--%>
    <%--<jsp:forward page="forward.jsp">--%>
        <%--<jsp:param name="str" value="aaa"></jsp:param>--%>
    <%--</jsp:forward>--%>

    <%
        //获取请求数据
        String s = request.getParameter("str");
    %>
    <%=s%>

    <a href="a/a.jsp">a.jsp</a>
 </body>

</html>
