<%@ page import="java.util.Date" %><%@ page import="java.text.SimpleDateFormat" %><%@ page import="java.net.URLEncoder" %><%@ page import="java.net.URLDecoder" %><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title><%= "显示时间" %></title>
  </head>
  <body>
  <%
    response.setContentType("text/html;charset=utf-8");

    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if(cookies != null && cookies.length > 0){
      for (Cookie cookie : cookies){
        String name = cookie.getName();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        format = URLEncoder.encode(format, "utf-8");
        cookie.setValue(format);
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);

        if ("lastTime".equals(name)){
          flag = true;
          String value = cookie.getValue();
          value = URLDecoder.decode(value, "utf-8");
  %>
          
    <h1>欢迎回来 <%= value %></h1>
    <%
          break;
        }
      }
    }

    if (cookies == null || cookies.length == 0 || flag == false){
      Date date = new Date();
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String format = simpleDateFormat.format(date);

      format = URLEncoder.encode(format, "utf-8");
      Cookie cookie = new Cookie("lastTime", format);
      cookie.setMaxAge(60*60*24*30);
      response.addCookie(cookie);
  %>

      
      <h1>
        欢迎首次访问
      </h1>
    <%
    }
  %>
    
  </body>
</html>
