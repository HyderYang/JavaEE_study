<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>el2获取域中数据</title>
  </head>
  <body>
  <%
    request.setAttribute("name", "张三");
    session.setAttribute("age", 23);
  %>

    <h3>el 获取值</h3>
    ${requestScope.name} <br>
    ${sessionScope.age} <br>

    <%--
    ${键名} :表示从小到大的域中查找是否有该键值对对应的值
    pageScope < requestScope < sessionScope < applicationScope
    --%>
  </body>
</html>
