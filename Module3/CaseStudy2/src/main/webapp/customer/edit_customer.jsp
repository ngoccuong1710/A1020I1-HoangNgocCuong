<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Customer</title>
    <link rel="stylesheet" href="boostrap/css/bootstrap.min.css">
</head>
<body>
<div>
    <jsp:include page='layout/header.jsp'/>
</div>

<div class="container-fluid">
    <div class="row" style="height: 81%">
        <div class="col-2">

        </div>
        <div class="col-10">
            <form method="post">
                <caption>
                    <h2>Update Customer</h2>
                </caption>
                <table class="table">
                    <tr>
                        <th>Name:</th>
                        <td>
                            <input type="text" name="name" id="name" value="<c:out value='${customer.name}'/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Birthday:</th>
                        <td>
                            <input type="date" name="birthday" id="birthday" value="<c:out value='${customer.birthday}'/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Gender:</th>
                        <td>
                            <div class="input-group mb-3">
                                <select class="form-select" id="inputGroupSelect01" name="gender">
                                    <option value="0" >Male</option>
                                    <option value="1">Female</option>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Id Card:</th>
                        <td>
                            <input type="text" name="idCard" id="idCard" value="<c:out value='${customer.idCard}'/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Phone:</th>
                        <td>
                            <input type="text" name="phone" id="phone" value="<c:out value='${customer.phone}'/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <td>
                            <input type="text" name="email" id="email" value="<c:out value='${customer.email}'/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Type Customer:</th>
                        <td>
                            <div class="input-group mb-3">
                                <select class="form-select" id="inputGroupSelect02" name="type">
                                    <option value="1">Diamond</option>
                                    <option value="2">Platinium</option>
                                    <option value="3">Gold</option>
                                    <option value="4">Silver</option>
                                    <option value="5">Copper</option>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Address:</th>
                        <td>
                            <input type="text" name="address" id="address" value="<c:out value='${customer.address}'/>"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input class="btn btn-outline-success" type="submit" value="Update Customer"/>
                        </td>
                    </tr>
                </table>

                <c:if test="${msg != null}">
                    <a>${msg}</a>
                </c:if>

            </form>
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
