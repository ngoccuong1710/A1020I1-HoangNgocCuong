<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add new Service</title>
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
            <form method="post" class="form-horizontal">
                <caption>
                    <h2>Add New Service</h2>
                </caption>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="area">Area:</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="area" name="area">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="cost">Cost:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="cost" name="cost">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="maxPeople">Max people:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="maxPeople" name="maxPeople">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="rentType">Rent type:</label>
                    <div class="col-sm-10">
                        <div class="input-group mb-3">
                            <select class="form-select" id="rentType" name="rentType">
                                <option selected>Choose...</option>
                                <option value="1">Hour</option>
                                <option value="2">Day</option>
                                <option value="3">Month</option>
                                <option value="4">Year</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="serviceType">Service type:</label>
                    <div class="col-sm-10">
                        <div class="input-group mb-3">
                            <select class="form-select" id="serviceType" name="serviceType" onchange="genderChanged(this)">
                                <option selected>Choose...</option>
                                <option value="1" id="villa">Villa</option>
                                <option value="2" id="house">House</option>
                                <option value="3" id="room">Room</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div id="showInput">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="standardRoom">Standard room:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="standardRoom" name="standardRoom">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="doc">Decription other convenience:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="doc" name="doc">
                        </div>
                    </div>
                    <div class="form-group" id="showPoolArea">
                        <label class="control-label col-sm-2" for="poolArea">Pool area:</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="poolArea" name="poolArea">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="numOfFloor">Number of floors:</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="numOfFloor" name="numOfFloor">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-outline-success">Add new Service</button>
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

<%--<script language="javascript">--%>
<%--    function genderChanged(obj)--%>
<%--    {--%>
<%--        var showInput = document.getElementById('showInput');--%>
<%--        var showPoolArea = document.getElementById('showPoolArea');--%>
<%--        var value = obj.value;--%>
<%--        if (value === '1'){--%>
<%--            showInput.style.display = 'block'--%>
<%--            showPoolArea.style.display = 'block'--%>
<%--        }--%>
<%--        else if (value === '2'){--%>
<%--            showInput.style.display = 'block'--%>
<%--            showPoolArea.style.display = 'none'--%>
<%--        }--%>
<%--        else if (value === '3'){--%>
<%--            showInput.style.display = 'none'--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>

<script src="boostrap/js/jquery-3.6.0.min.js"></script>
<script src="boostrap/js/bootstrap.min.js"></script>
</body>
</html>
