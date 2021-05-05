<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>Product Discount Calculator</h1>
    <form method="post" action="discount">
      <label>Product Description</label><br>
      <input type="text" name="productDescription" placeholder="mo ta san pham"><br>
      <label>List Price</label><br>
      <input type="text" name="listPrice" placeholder="gia"><br>
      <label>Discount Percent</label><br>
      <input type="text" name="discountPercent" placeholder="ty le chiet khau"><br>
      <input type="submit" id="sumit" value="Calculate Discount">
    </form>
  </body>
</html>
