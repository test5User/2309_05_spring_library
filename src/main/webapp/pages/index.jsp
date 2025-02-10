<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Libraries</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h1>Libraries:</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="library" items="${libraries}">
            <tr>
                <td>${library.name}</td>
                <td>${library.address}</td>
                <td>
                    <a href="/view/${library.id}">View</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
