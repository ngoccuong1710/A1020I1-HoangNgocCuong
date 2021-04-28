<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ServerTime</title>
  </head>
  <body>
  <form action="/index" method="post">
    <h1 style="color: blue"><%=request.getAttribute("day")%></h1>
  </form>
  </body>
</html>
