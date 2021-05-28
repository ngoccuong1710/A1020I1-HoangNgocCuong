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
            <a class="btn btn-primary" href="customer?action=create-employee">Add Employee</a>
        </div>
        <div class="col-11">
            <div class="row">
                <div class="col-12">
                    <table class="table table-striped">
                        <tr class="bg-dark text-white">
                            <td>Id</td>
                            <td>Name</td>
                            <td>Birthday</td>
                            <td>Id Card</td>
                            <td>Salary</td>
                            <td>Phone</td>
                            <td>Email</td>
                            <td>Address</td>
                            <td>Position</td>
                            <td>Education degree</td>
                            <td>Division</td>
                            <td>Edit</td>
                            <td>Delete</td>
                        </tr>

                        <c:forEach var="employee" items="${employeeList}">
                            <tr>
                                <td><c:out value="${employee.id}"/></td>
                                <td><c:out value="${employee.name}"/></td>
                                <td><c:out value="${employee.birthday}"/></td>
                                <td><c:out value="${employee.idCard}"/></td>
                                <td><c:out value="${employee.salary}"/></td>
                                <td><c:out value="${employee.phone}"/></td>
                                <td><c:out value="${employee.email}"/></td>
                                <td><c:out value="${employee.address}"/></td>
                                <td><c:out value="${employee.position}"/></td>
                                <td><c:out value="${employee.educationDegree}"/></td>
                                <td><c:out value="${employee.division}"/></td>
                                <td><a class="btn btn-warning" href="customer?action=edit-employee&id=${employee.id}">Edit</a>
                                </td>
                                <td><a class="btn btn-danger" href="customer?action=delete-employee&id=${employee.id}">Delete</a>
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
