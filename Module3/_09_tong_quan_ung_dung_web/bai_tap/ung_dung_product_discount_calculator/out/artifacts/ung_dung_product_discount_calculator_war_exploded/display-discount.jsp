
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Display Discount</h1>
    <h3>Product Description:</h3><br>
    <a><%=request.getAttribute("productDescription")%></a><br>
    <h3>List Price:</h3><br>
    <a><%=request.getAttribute("listPrice")%></a><br>
    <h3>Discount Percent:</h3><br>
    <a><%=request.getAttribute("discountPercent")%></a><br>
    <h3>Dicount Amount:</h3><br>
    <a><%=request.getAttribute("discountAmount")%></a><br>
    <h2 style="color: red">Dicount Price:</h2><br>
    <a><%=request.getAttribute("discountPrice")%></a><br>
</body>
</html>
