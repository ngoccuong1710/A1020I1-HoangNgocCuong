<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update product</title>
</head>
<body>
    <h1>Update product</h1>
    <p><a href="products">Back to products list</a></p>
    <form method="post">
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${productUpdate.name}"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price" value="${productUpdate.price}"></td>
                </tr>
                <tr>
                    <td>Describe:</td>
                    <td><input type="text" name="describe" value="${productUpdate.describe}"></td>
                </tr>
                <tr>
                    <td>Production company:</td>
                    <td><input type="text" name="productionCompany" value="${productUpdate.productionCompany}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
