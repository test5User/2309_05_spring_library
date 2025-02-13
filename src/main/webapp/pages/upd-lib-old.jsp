<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Old</title>
</head>
<body>
    <form action="/saveOld" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <input name="name" value="${param.name}">
        <input name="address" value="${param.address}">
        <input type="submit" value="Update">
    </form>
</body>
</html>
