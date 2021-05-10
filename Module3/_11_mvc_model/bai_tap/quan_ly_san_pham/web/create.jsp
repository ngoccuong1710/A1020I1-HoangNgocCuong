<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
    <h1>Create new product</h1>
    <p><a href="products">Back to products list</a></p>
    <p style="color: red">
        <c:if test="${msg != null}">
            <a>${msg}</a>
        </c:if>
    </p>
    <form method="post" action="?action=create">
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price"></td>
                </tr>
                <tr>
                    <td>Describe:</td>
                    <td><input type="text" name="describe"></td>
                </tr>
                <tr>
                    <td>Production company:</td>
                    <td><input type="text" name="productionCompany"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
