<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Detail</h1>
    <p><a href="products">Back to products list</a></p>
    <p style="color: red">
    <c:if test="${msg != null}">
        <a>${msg}</a>
    </c:if>
    </p>
    <table>
        <tr>
            <td>Id:</td>
            <td><c:out value="${productSearch.id}"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><c:out value="${productSearch.name}"/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><c:out value="${productSearch.price}"/></td>
        </tr>
        <tr>
            <td>Describe:</td>
            <td><c:out value="${productSearch.describe}"/></td>
        </tr>
        <tr>
            <td>Production company:</td>
            <td><c:out value="${productSearch.productionCompany}"/></td>
        </tr>
    </table>
</body>
</html>
