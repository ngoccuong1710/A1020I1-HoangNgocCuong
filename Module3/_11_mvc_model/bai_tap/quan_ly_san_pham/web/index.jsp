<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Product list</title>
  </head>
  <body>
    <h1>Product</h1>
    <p><a href="?action=create">Create new product</a></p>
    <form method="post" action="?action=search">
      <p>
        <input type="text" name="search" placeholder="search">
        <input type="submit" value="Search">
      </p>
    </form>
    <table border="1">
      <tr>
        <td>id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Describe</td>
        <td>Production Company</td>
        <td>Show</td>
        <td>Edit</td>
        <td>Delete</td>
      </tr>

      <c:forEach var="product" items="${productList}">
        <tr>
          <td><c:out value="${product.id}"/></td>
          <td><c:out value="${product.name}"/></td>
          <td><c:out value="${product.price}"/></td>
          <td><c:out value="${product.describe}"/></td>
          <td><c:out value="${product.productionCompany}"/></td>
          <td><a href="?action=show&id=${product.id}">show</a></td>
          <td><a href="?action=update&id=${product.id}">edit</a></td>
          <td><a href="?action=delete&id=${product.id}">delete</a></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
