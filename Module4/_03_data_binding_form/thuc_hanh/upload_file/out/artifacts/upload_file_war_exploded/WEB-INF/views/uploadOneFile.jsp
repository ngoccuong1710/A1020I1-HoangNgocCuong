<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Upload One FIle</h3>
    <form:form modelAttribute="uploadForm" method="post" action="result" enctype="multipart/form-data">
        Decription:<form:input path="description" />
<%--        File to upload:<form:input path="multipartFile" type = "file"/>--%>
        <input type="submit" value="Upload">
    </form:form>
</body>
</html>
