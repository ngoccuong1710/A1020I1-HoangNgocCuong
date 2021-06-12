<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/customers/list">Back to list</a>.
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Id</td>
                <td>${customerInfo.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${customerInfo.name}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${customerInfo.email}</td>
            </tr>
            <tr>
                <td>Address</td>
                <td>${customerInfo.address}</td>
            </tr>
        </table>
    </fieldset>
</body>
</html>
