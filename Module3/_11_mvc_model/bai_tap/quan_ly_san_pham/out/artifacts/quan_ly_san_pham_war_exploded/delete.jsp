<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
    <h1>Delete product</h1>
    <p>
        <a href="products">Back to product list</a>
    </p>
    <form method="post">
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>Id:</td>
                    <td><c:out value="${productDelete.id}"/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><c:out value="${productDelete.name}"/></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><c:out value="${productDelete.price}"/></td>
                </tr>
                <tr>
                    <td>Describe:</td>
                    <td><c:out value="${productDelete.describe}"/></td>
                </tr>
                <tr>
                    <td>Production company:</td>
                    <td><c:out value="${productDelete.productionCompany}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Delete product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
