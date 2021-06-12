<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3 style="color: red">${mes}</h3>
    <form method="post" action="/validate">
      <input type="text" name="email">
      <input type="submit" value="Validate">
    </form>
  <h3>${email}</h3>
  </body>
</html>
