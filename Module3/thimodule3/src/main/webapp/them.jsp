<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="matbang?action=list">Danh sách mặt bằng</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Danh sách mặt bằng</h2>
            </caption>
            <tr>
                <th>Mã mạt bằng</th>
                <td>
                    <input type="text" name="ma" id="ma" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Diện tích</th>
                <td>
                    <input type="text" name="dienTich" id="dienTich" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Trạng thái</th>
                <td>
                    <select class="form-select" id="trangThai" name="trangThai">
                        <option selected>Choose...</option>
                        <option value="0">Trống</option>
                        <option value="1">Hạ tầng</option>
                        <option value="2">Đầy đủ</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Tầng</th>
                <td>
                    <input type="number" name="tang" id="tang" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Loại văn phòng</th>
                <td>
                    <select class="form-select" id="loai" name="loai">
                        <option selected>Choose...</option>
                        <option value="0">Văn phòng chia sẻ</option>
                        <option value="1">Văn phòng trọn gói</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Mô tả chi tiết</th>
                <td>
                    <input type="text" name="moTa" id="moTa" size="45"/>
                </td>
            </tr>
                <th>Giá cho thuê</th>
                <td>
                    <input type="text" name="gia" id="gia" size="45"/>
                </td>
            </tr>
                <th>Ngày bắt đầu</th>
                <td>
                    <input type="date" name="ngaybatdau" id="ngaybatdau" size="45"/>
                </td>
                <th>Ngày kết thúc</th>
                <td>
                    <input type="date" name="ngayketthuc" id="ngayketthuc" size="45"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Thêm"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
