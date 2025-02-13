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
                    <a href="/delete?id=${library.id}">Delete</a>
                    <a href="/upd/${library.id}">Update</a>
                    <a href="/pages/upd-lib-old.jsp?id=${library.id}&name=${library.name}&address=${library.address}">Update-Old</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <form action="/add" method="post">
            <input name="name" placeholder="Name" required><br>
            <input name="address" placeholder="Address" required><br>
            <input type="submit" value="Add">
        </form>
    </div>
</body>
</html>
