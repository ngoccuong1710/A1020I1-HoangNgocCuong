<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table class="table" border="1">
        <thead>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.id}</td>
                    <td><a href="info/${customer.id}">${customer.name}</a></td>
                    <td>${customer.email}</td>
                    <td>${customer.address}</td>
                    <td><a href="/update/${customer.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
