
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
  <h2>Vietnamese Dictionary</h2>
  <form method="post" action="/index">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
    <h1><%=request.getAttribute("result")%></h1>
  </form>
  </body>
</html>
