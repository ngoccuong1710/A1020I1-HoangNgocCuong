<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h2>
            <a href="matbang?action=them">Thêm mặt bằng</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Danh sach mat bang</h2></caption>

            <tr>
                <td>No</td>
                <td>Ma</td>
                <td>Diện tích</td>
                <td>Trạng thái</td>
                <td>Tầng</td>
                <td>Loại văn phòng</td>
                <td>Mô tả</td>
                <td>Giá</td>
                <td>Ngày bắt đầu</td>
                <td>Ngày kết thúc</td>
            </tr>

            <c:forEach var="matbang" items="${matBangList}">
                <tr>
                    <td><c:out value="${matbang.no}"/></td>
                    <td><c:out value="${matbang.maMatBang}"/></td>
                    <td><c:out value="${matbang.dienTich}"/></td>
                    <td>
                        <c:if test="${matbang.trangThai == 0}">
                            <c:out value = "Trống"/><p>
                        </c:if>
                        <c:if test="${matbang.trangThai == 1}">
                            <c:out value = "hạ tầng"/><p>
                        </c:if>
                        <c:if test="${matbang.trangThai == 2}">
                            <c:out value = "đầy đủ"/><p>
                        </c:if>
                    </td>
                    <td><c:out value="${matbang.tang}"/></td>
                    <td>
                        <c:if test="${matbang.loaiVanPhong == 0}">
                            <c:out value = "Văn phòng chia sẻ"/><p>
                        </c:if>
                        <c:if test="${matbang.loaiVanPhong == 1}">
                            <c:out value = "Văn phòng trọn gói"/><p>
                        </c:if>
                    </td>
                    <td><c:out value="${matbang.moTa}"/></td>
                    <td><c:out value="${matbang.gia}"/></td>
                    <td><c:out value="${matbang.ngayChoThue}"/></td>
                    <td><c:out value="${matbang.ngayKetThuc}"/></td>
                    <td>
                        <a href="matbang?action=xoa&id=${matbang.no}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
