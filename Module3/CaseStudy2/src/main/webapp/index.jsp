<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="boostrap/css/bootstrap.min.css">
</head>
<body>
<div>
    <jsp:include page='layout/header.jsp'/>
</div>

<div class="container-fluid">
    <div class="row" style="height: 81%">
        <div class="col-2 text-center">
            <div class="btn-group-vertical" role="group" aria-label="Basic radio toggle button group">
                <a class="btn btn-outline-primary" href="customer?action=create-customer">Add Customer</a>

                <a class="btn btn-outline-primary" href="#">Add Employee</a>

                <a class="btn btn-outline-primary" href="#">Add Service</a>
            </div>
        </div>
        <div class="col-10">

        </div>
    </div>
</div>

<div>
    <jsp:include page='layout/footer.jsp'/>
</div>

<script src="boostrap/js/jquery-3.6.0.min.js"></script>
<script src="boostrap/js/bootstrap.min.js"></script>
</body>
</html>
