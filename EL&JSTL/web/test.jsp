<%@ page import="java.util.ArrayList" %><%@ page import="com.hyder.el.User" %><%@ page import="java.util.Date" %><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>JSTL练习</title>
  </head>
  <body>
    
    <%
      ArrayList<User> users = new ArrayList<>();
      users.add(new User("张三", 21, new Date()));
      users.add(new User("李四", 22, new Date()));
      users.add(new User("王五", 23, new Date()));

      request.setAttribute("list", users);
    %>

      <table>
        <tr>
          <th>编号</th>
          <th>姓名</th>
          <th>年龄</th>
          <th>日期</th>
        </tr>
        <c:forEach items="${list}" var="user" varStatus="s">
          <tr>
            <td>${s.index + 1}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.birStr}</td>
          </tr>
        </c:forEach>
      </table>
  </body>
</html>
