<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Product list</title>
  </head>
  <body>
    <h1>Product</h1>
    <p><a href="/products?action=create">Create new product</a></p>
    <table border="1">
      <tr>
        <td>id</td>
        <td>Tên sản phẩm</td>
        <td>giá</td>
        <td>Mô tả</td>
        <td>Nhà sản xuất</td>
        <td>Xem chi tiết</td>
        <td>Sửa</td>
        <td>Xóa</td>
      </tr>

      <c:forEach var="product" items="${products}">
        <tr>
          <td>${product.getId()}</td>
          <td>${product.getName()}</td>
          <td>${product.getPrice()}</td>
          <td>${product.getDescribe()}</td>
          <td>${product.getProductionCompany()}</td>
          <td><a href="/products?action=view">Xem</a></td>
          <td><a href="/products?action=update">Sửa</a></td>
          <td><a href="/products?action=delete">Xóa</a></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
