<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/list">Back to list</a>
    <form method="post" action="/create">
        <label for="Lettuce">Lettuce</label>
        <input type="checkbox" name="condiment" id="Lettuce" value="Lettuce">

        <label for="Tomato">| Tomato </label>
        <input type="checkbox" name="condiment" id="Tomato" value="Tomato">

        <label for="Mustard">| Mustard </label>
        <input type="checkbox" name="condiment" id="Mustard" value="Mustard">

        <label for="Sprouts">| Sprouts </label>
        <input type="checkbox" name="condiment" id="Sprouts" value="Sprouts"><br>

        <input type="submit" value="Save">
    </form>
</body>
</html>
