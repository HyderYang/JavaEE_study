<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
  <head>
    <title>JSTL2</title>
  </head>
  <body>
    <%
      request.setAttribute("number", 3);
    %>

    <c:choose>
      <c:when test="${number == 1}">星期1</c:when>
      <c:when test="${number == 2}">星期2</c:when>
      <c:when test="${number == 3}">星期3</c:when>
      <c:when test="${number == 4}">星期4</c:when>
      <c:when test="${number == 5}">星期5</c:when>
      <c:when test="${number == 6}">星期6</c:when>
      <c:when test="${number == 7}">星期7</c:when>

      <c:otherwise>输入错误</c:otherwise>
    </c:choose>
  </body>
</html>
