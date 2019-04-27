<%--
  Created by IntelliJ IDEA.
  User: hyder
  Date: 2019-04-27
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <% System.out.println("jsp标签"); %>
    
    <% out.print("你好"); %>
    <% out.print(request.getParameter("a")); %>
  </body>
</html>
