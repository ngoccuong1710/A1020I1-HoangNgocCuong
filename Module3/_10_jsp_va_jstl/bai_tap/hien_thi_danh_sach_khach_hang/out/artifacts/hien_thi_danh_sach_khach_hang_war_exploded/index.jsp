<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h2>List Customer</h2>
    <table>
      <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>ảnh</th>
      </tr>

      <c:forEach var="customer" items="${customerListServlet}">
        <tr>
          <td><c:out value="${customer.name}"></c:out></td>
          <td><c:out value="${customer.dayOfBirth}"></c:out></td>
          <td><c:out value="${customer.address}"></c:out></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
