<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Library</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h1>Library ${library.name}</h1>
    <h2>Address ${library.address}</h2>
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Pages</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${library.books}">
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.pages}</td>
                <td>
                    <a href="/updBook/${book.id}">Update Book</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <a href="/addBook/${library.id}">Add new book</a>
    </div>

</body>
</html>
