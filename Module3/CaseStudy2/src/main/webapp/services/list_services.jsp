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
            <a class="btn btn-primary" href="index?action=create-services">Add Service</a>
        </div>
        <div class="col-11">
            <div class="row">
                <div class="col-12">
                    <table class="table table-striped">
                        <tr class="bg-dark text-white">
                            <td>Id</td>
                            <td>Name</td>
                            <td>Area</td>
                            <td>Cost</td>
                            <td>Max people</td>
                            <td>Rent type</td>
                            <td>Service type</td>
                            <td>Standard room</td>
                            <td>Other convenience</td>
                            <td>Pool area</td>
                            <td>Num of floor</td>
                            <td>Edit</td>
                            <td>Delete</td>
                        </tr>

                        <c:forEach var="services" items="${servicesList}">
                            <tr>
                                <td><c:out value="${services.id}"/></td>
                                <td><c:out value="${services.name}"/></td>
                                <td><c:out value="${services.area}"/></td>
                                <td><c:out value="${services.cost}"/></td>
                                <td><c:out value="${services.maxPeople}"/></td>
                                <td><c:out value="${services.rentType}"/></td>
                                <td><c:out value="${services.serviceType}"/></td>
                                <td><c:out value="${services.standardRoom}"/></td>
                                <td><c:out value="${services.decriptionOtherConvenience}"/></td>
                                <td><c:out value="${services.poolArea}"/></td>
                                <td><c:out value="${services.numOfFloors}"/></td>
                                <td><a class="btn btn-warning" href="index?action=edit-services&id=${services.id}">Edit</a>
                                </td>
                                <td><a class="btn btn-danger" href="index?action=delete-services&id=${services.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <div class="container">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#">Trước</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
                <li class="page-item"><a class="page-link" href="#">Sau</a></li>
            </ul>
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
