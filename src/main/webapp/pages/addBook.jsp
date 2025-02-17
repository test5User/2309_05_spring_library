<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add book page</title>
</head>
<body>
    <sf:form method="post" action="/saveBook" modelAttribute="book">
        <sf:input path="library_id" type="hidden"/>
        <sf:input path="title" placeholder="title"/><br>
        <sf:input path="author" placeholder="author"/><br>
        <sf:input path="pages" placeholder="pages"/><br>
        <input type="submit" value="Add...">
    </sf:form>
</body>
</html>
