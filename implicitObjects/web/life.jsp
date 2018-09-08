<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/9/8
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%!
    public void jspInit(){
        System.out.println("jspInit ...");
    }
    public void jspDestroy(){
        System.out.println("jspDestroy ...");
    }

%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jspInit and jspDestroy</title>
</head>
<body>
Overriding jspInit and jspDestroy
</body>
</html>
