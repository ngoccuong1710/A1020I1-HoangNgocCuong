<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <head>
    <title>Customer</title>
  </head>
  <body>
    <h2>List Customer</h2>
    <table border="1">
      <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>ảnh</th>
      </tr>

      <c:forEach var="customer" items="${customerListServlet}">
        <tr>
          <td><c:out value="${customer.name}"/></td>
          <td><c:out value="${customer.dayOfBirth}"/></td>
          <td><c:out value="${customer.address}"/></td>
          <td><img src="${pageContext.request.contextPath}${customer.img}" style="width: 50px; height: 50px;"/></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
