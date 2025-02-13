<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Library</title>
</head>
<body>
    <sf:form method="post" action="/save" modelAttribute="library">
        <sf:input type="hidden" path="id"/><br>
        <sf:input path="name" placeholder="Name"/>
        <sf:input path="address" placeholder="Adderss"/>
        <input type="submit" value="Update">
    </sf:form>
</body>
</html>
