<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/9/8
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Taday's date</title>
  </head>
  <body>
  <%
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
    String s = dateFormat.format(new Date());
    out.println("Today is " + s);
  %>
  </body>
</html>
