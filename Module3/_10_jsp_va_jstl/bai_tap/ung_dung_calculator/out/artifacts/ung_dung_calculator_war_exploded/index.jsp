<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
    <h1>Simple Calculator</h1>
    <form action="calculate" method="get">
      <fieldset style="width: 18%">
        <legend>Simple Calculator</legend>
        <a>Calculator</a>
        <table>
          <tr>
            <td>First operator:</td>
            <td><input name="firstNum" type="text"></td>
          </tr>
          <tr>
            <td>Operand:</td>
            <td>
              <select name="operator">
                <option value="+">Addition</option>
                <option value="-">Subtraction</option>
                <option value="*">Multiplication</option>
                <option value="/">Division</option>
              </select>
            </td>
          </tr>
          <tr>
            <td>Second operand:</td>
            <td><input name="secondNum" type="text"></td>
          </tr>
          <tr>
            <td><input type="submit" value="Calculate"></td>
          </tr>
          <tr>
            <td>Result:</td>
            <td>
              <%=request.getAttribute("result")%>
            </td>
          </tr>
        </table>
      </fieldset>
    </form>
  </body>
</html>
