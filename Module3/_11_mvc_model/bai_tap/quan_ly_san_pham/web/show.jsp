<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show product</title>
</head>
<body>
    <h1>Product details</h1>
    <p><a href="products">Back to products list</a></p>
    <table>
        <tr>
            <td>Id:</td>
            <td><c:out value="${productShow.id}"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><c:out value="${productShow.name}"/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><c:out value="${productShow.price}"/></td>
        </tr>
        <tr>
            <td>Describe:</td>
            <td><c:out value="${productShow.describe}"/></td>
        </tr>
        <tr>
            <td>Production company:</td>
            <td><c:out value="${productShow.productionCompany}"/></td>
        </tr>
    </table>
</body>
</html>
