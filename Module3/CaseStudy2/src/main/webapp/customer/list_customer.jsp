<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="../boostrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../datatables/css/jquery.dataTables.min.css" />
</head>
<body>
<div>
    <jsp:include page='layout/header.jsp'/>
</div>

<div class="container-fluid">
    <div class="row" style="height: 81%">
        <div class="col-1 text-center">
            <a class="btn btn-primary" href="index?action=create-customer">Add Customer</a>
        </div>
        <div class="col-11">
            <div class="row">
                <div class="col-lg-12">
                    <table class="table table-striped table-bordered w-100" id="tableCustomer">
                        <thead>
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
                        </thead>

                        <tbody>
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
                                    <td><a class="btn btn-warning" href="index?action=edit-customer&id=${customer.id}">Edit</a>
                                    </td>
                                    <td><a class="btn btn-danger" href="index?action=delete-customer&id=${customer.id}" onclick="customerSetId('${customer.id}','${customer.name}')"
                                           data-toggle="modal" data-target="#deleteModal">Delete</a></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <jsp:include page='layout/footer.jsp'/>
    </div>
</div>

<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="modelId" size="50" disabled style="border: none;background: white; color: red">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitDelete()">Delete</button>
            </div>
        </div>
    </div>
</div>

<form method="post" id="deleteCustomer">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" id="id">
</form>



<script src="../boostrap/js/jquery-3.6.0.min.js"></script>
<script src="../bootstrap413/js/bootstrap.bundle.min.js"></script>
<%--<script src="jquery/jquery-3.5.1.min.js"></script>--%>
<script src="../datatables/js/jquery.dataTables.js"></script>
<script src="../datatables/js/dataTables.bootstrap.js"></script>
<script>

    function customerSetId(id, name) {
        document.getElementById("id").value = id;
        document.getElementById("modelId").value = "Do you want delete customer name: " + name;
    }

    function submitDelete() {
        <!-- để submit form delete  -->
        document.getElementById("deleteCustomer").submit();
    }

</script>

<script>
    $(document).ready(function() {
        $('#tableCustomer').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>

</body>
</html>
