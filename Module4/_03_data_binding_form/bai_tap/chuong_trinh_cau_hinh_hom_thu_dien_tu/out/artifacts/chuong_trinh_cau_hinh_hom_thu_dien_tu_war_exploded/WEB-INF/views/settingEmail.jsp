<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form:form method="post" action="/settingEmail" modelAttribute="email">
      <table>
        <tr>
          <td><form:label path="language">Language</form:label></td>
          <td>
            <form:select path="language">
              <form:option value="NONE" label="Select"/>
              <form:options items="${listLanguage}"/>
            </form:select>
          </td>
        </tr>
        <tr>
          <td><form:label path= "pageSIze">Page Size</form:label></td>
          <td>
            Show
            <form:select path="pageSIze">
              <form:option value="NONE" label="Select"/>
              <form:options items="${listPageSize}"/>
            </form:select>
            emails per page
          </td>
        </tr>
        <tr>
          <td><form:label path= "pageSIze">Spams filter</form:label></td>

        </tr>
        <tr><input type="submit" value="Update"/></tr>
      </table>
    </form:form>
  </body>
</html>
