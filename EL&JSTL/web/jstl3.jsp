<%@ page import="java.util.List" %><%@ page import="java.util.ArrayList" %><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>foreach标签</title>
  </head>
  <body>

    <c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
      ${i} <h3>${s.index}</h3> <h4>${s.count}</h4> <br>
    </c:forEach>

    <%
      List list = new ArrayList();
      list.add("aaaa");
      list.add("bbbb");
      list.add("cccc");

      request.setAttribute("list", list);
    %>

    <c:forEach items="${list}" var="str" varStatus="stat">
      <span>
        ${stat.index} - ${stat.count} - ${str} <br>
      </span>
    </c:forEach>



  </body>
</html>
