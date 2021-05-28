<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="boostrap/css/bootstrap.min.css">
</head>
<body>
<div>
    <jsp:include page='layout/header.jsp'/>
</div>

<div class="container-fluid">
    <div class="row" style="height: 81%">
        <div class="col-1 text-center">
            <a class="btn btn-primary" href="customer?action=create-customer">Add Customer</a>
        </div>
        <div class="col-11">
            <div class="row">
                <div class="col-12">
                    <table class="table table-striped">
                        <tr class="bg-dark text-white">
                            <td>Id</td>
                            <td>Name</td>
                            <td>Birthday</td>
                            <td>Gender</td>
                            <td>Id Card</td>
                            <td>Phone</td>
                            <td>Email</td>
                            <td>Type Customer</td>
                            <td>Address</td>
                            <td>Edit</td>
                            <td>Delete</td>
                        </tr>

                        <c:forEach var="customer" items="${customerList}">
                            <tr>
                                <td><c:out value="${customer.id}"/></td>
                                <td><c:out value="${customer.name}"/></td>
                                <td><c:out value="${customer.birthday}"/></td>
                                <td>
                                    <c:if test="${customer.gender == 0}">
                                        <c:out value = "Male"/><p>
                                    </c:if>
                                    <c:if test="${customer.gender == 1}">
                                        <c:out value = "Female"/><p>
                                    </c:if>
                                </td>
                                <td><c:out value="${customer.idCard}"/></td>
                                <td><c:out value="${customer.phone}"/></td>
                                <td><c:out value="${customer.email}"/></td>
                                <td><c:out value="${customer.type}"/></td>
                                <td><c:out value="${customer.address}"/></td>
                                <td><a class="btn btn-warning" href="customer?action=edit-customer&id=${customer.id}">Edit</a>
                                </td>
                                <td><a class="btn btn-danger" href="customer?action=delete-customer&id=${customer.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <jsp:include page='layout/footer.jsp'/>
    </div>
</div>


<script src="boostrap/js/jquery-3.6.0.min.js"></script>
<script src="boostrap/js/bootstrap.min.js"></script>
</body>
</html>
