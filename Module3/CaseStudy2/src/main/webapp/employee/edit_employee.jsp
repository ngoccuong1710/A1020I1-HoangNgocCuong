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
                    <h2>Update Employee</h2>
                </caption>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" placeholder="Nhập họ và tên" value="<c:out value='${employee.name}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="birthday">Birthday:</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="birthday" name="birthday" placeholder="Nhập ngày tháng năm sinh" value="<c:out value='${employee.birthday}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="idCard">Id Card:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="idCard" name="idCard" placeholder="Nhập id card" value="<c:out value='${employee.idCard}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="salary">Salary:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="salary" name="salary" placeholder="Nhập lương" value="<c:out value='${employee.salary}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="phone">Phone:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="090xxxxxxx or 091xxxxxxx" value="<c:out value='${employee.phone}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="email">Email:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" placeholder="Nhập email" value="<c:out value='${employee.email}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="address">Address:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="address" name="address" placeholder="Nhập địa chỉ" value="<c:out value='${employee.address}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="position">Position:</label>
                    <div class="col-sm-10">
                        <div class="input-group mb-3">
                            <select class="form-select" id="position" name="position">
                                <option value="1">Giám đốc</option>
                                <option value="2">Phó giám đốc</option>
                                <option value="3">Thư ký</option>
                                <option value="3">Trưởng phòng nhân sự</option>
                                <option value="3">Trưởng phòng tư vấn</option>
                                <option value="3">Trưởng phòng hành chính</option>
                                <option value="3">Nhân Viên</option>
                                <option value="3">Bảo vệ</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="educationDegree">Education degree:</label>
                    <div class="col-sm-10">
                        <div class="input-group mb-3">
                            <select class="form-select" id="educationDegree" name="educationDegree">
                                <option value="1">Bậc trung học</option>
                                <option value="2">Bậc đại học</option>
                                <option value="3">Bậc cao học</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="division">Divition:</label>
                    <div class="col-sm-10">
                        <div class="input-group mb-3">
                            <select class="form-select" id="division" name="division">
                                <option value="1">Bộ phận kinh doanh</option>
                                <option value="2">Bộ phận kỹ thuật</option>
                                <option value="3">Bộ phận kế toán</option>
                                <option value="4">Bộ phận nhân sự</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="username">Username:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username" name="username" placeholder="Nhập username" value="<c:out value='${employee.username}'/>">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-outline-success">Update Employee</button>
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
