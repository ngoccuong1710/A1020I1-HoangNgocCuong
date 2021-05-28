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
        <div class="col-1">

        </div>
        <div class="col-11">
            <form method="post">
                <caption>
                    <h2>Update Customer</h2>
                </caption>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" placeholder="Nhập họ và tên" value="<c:out value='${customer.name}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="birthday">Birthday:</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="birthday" name="birthday" placeholder="Nhập ngày tháng năm sinh" value="<c:out value='${customer.birthday}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="gender">Gender:</label>
                    <div class="col-sm-10">
                        <div class="input-group mb-3">
                            <select class="form-select" id="gender" name="gender">
                                <option value="0">Male</option>
                                <option value="1">Female</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="idCard">Id Card:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="idCard" name="idCard" placeholder="Nhập id card" value="<c:out value='${customer.idCard}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="phone">Phone:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="090xxxxxxx or 091xxxxxxx" value="<c:out value='${customer.phone}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="email">Email:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" placeholder="Nhập email" value="<c:out value='${customer.email}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="type">Customer Type:</label>
                    <div class="col-sm-10">
                        <div class="input-group mb-3">
                            <select class="form-select" id="type" name="type">
                                <option value="1">Diamond</option>
                                <option value="2">Platinium</option>
                                <option value="3">Gold</option>
                                <option value="4">Silver</option>
                                <option value="5">Copper</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="address">Address:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="address" name="address" placeholder="Nhập địa chỉ" value="<c:out value='${customer.address}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-outline-success">Update Customer</button>
                    </div>
                </div>

                <c:if test="${msg != null}">
                    <a>${msg}</a>
                </c:if>

            </form>
        </div>
        <div class="container-fluid">
            <jsp:include page='layout/footer.jsp'/>
        </div>
    </div>
</div>

<script src="boostrap/js/jquery-3.6.0.min.js"></script>
<script src="boostrap/js/bootstrap.min.js"></script>
</body>
</html>
