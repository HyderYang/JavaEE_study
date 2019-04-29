<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>JSTL01</title>
  </head>
  <body>
    <%--
    if标签
        1. 属性：
            * test 必须属性，接受boolean表达式
                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
                * 一般情况下，test属性值会结合el表达式一起使用

        2. 注意：c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签
    --%>

    <c:if test="false">
      <h1>我是假的</h1>
    </c:if>

    <c:if test="true">
      <h1>我是假的</h1>
    </c:if>
  </body>
</html>
